
package at.plate.lab.rabbitmq;

import java.util.*;

import javax.inject.Inject;


import com.fasterxml.jackson.databind.ObjectMapper;

public class UserSimulator implements Runnable {
    private static final String[] TOPICS = {"science", "politics", "sports", "fashion", "literature", "economy"};
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final long userId, maxUserId;
    private final UserMessageManagerWithTopics userMessageManager;

    @Inject
    public UserSimulator(final long userId,
                         final long maxUserId,
                         final UserMessageManagerWithTopics userMessageManager) {
        this.userId = userId;
        this.maxUserId = maxUserId;
        this.userMessageManager = userMessageManager;
    }

    private static Set<String> getTwoTopics() {
        int min = 0;
        int max = TOPICS.length;
        int randomNumberOne = (int) (Math.random() * (max - min));
        int randomNumberTwo = (int) (Math.random() * (max - min));

        Set<String> result = new HashSet<>();
        result.add(TOPICS[randomNumberOne]);
        result.add(TOPICS[randomNumberTwo]);
        return result;
    }

    @Override
    public void run() {
        userMessageManager.onUserLogin(userId);

        userMessageManager.onUserTopicInterestChange(userId, getTwoTopics(),
                Collections.<String>emptySet());

        System.out.printf("User login: %d%n", userId);

        while (!Thread.currentThread().isInterrupted()) {
            try {
                final List<String> messages = userMessageManager.fetchUserMessages(userId);
                if (messages != null) {
                    for (final String message : messages) {
                        System.out.printf("User %d received: %s%n", userId, message);
                    }
                }

                if (Math.random() < .25) {
                    final Long addresseeUserId = Long.valueOf(1 + new Random().nextInt((int) maxUserId));
                    if (addresseeUserId != userId) {
                        Message message = new Message();
                        message.setSenderId(userId);
                        message.setAddresseeId(addresseeUserId);
                        message.setSubject("Greetings!");
                        message.setContent("Hello from: " + userId);
                        message.setTimeSent(System.currentTimeMillis());

                        final String jsonMessage = OBJECT_MAPPER.writeValueAsString(message);
                        userMessageManager.sendUserMessage(addresseeUserId, jsonMessage);
                        System.out.printf("User %d send to %d: %s%n", userId, addresseeUserId, jsonMessage);
                    }
                }

                if (Math.random() < .05) {
                    final String topic = TOPICS[new Random().nextInt(TOPICS.length)];
                    Message message = new Message();
                    message.setSenderId(userId);
                    message.setTopic(topic);
                    message.setSubject("Something about " + topic);
                    message.setContent("Great content about " + topic);
                    message.setTimeSent(System.currentTimeMillis());

                    final String jsonMessage = OBJECT_MAPPER.writeValueAsString(message);
                    userMessageManager.sendTopicMessage(topic, jsonMessage);
                    System.out.printf("User %d send to %s: %s%n", userId, topic, jsonMessage);
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000L);
            } catch (final InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

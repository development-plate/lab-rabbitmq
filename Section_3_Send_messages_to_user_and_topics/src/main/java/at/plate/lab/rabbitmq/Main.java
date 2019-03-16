
package at.plate.lab.rabbitmq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rabbitmq.client.ConnectionFactory;

public class Main {
    public static void main(final String[] args) throws Exception {
        //create factory
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("userdev");
        factory.setPassword("userdev");
        factory.setHost("localhost");
        factory.setPort(5672);

        // simulate dependency management creation and wiring
        final RabbitMqManager rabbitMqManager = new RabbitMqManager(factory);
        rabbitMqManager.start();

        final UserMessageManagerWithTopics userMessageManager = new UserMessageManagerWithTopics();
        userMessageManager.rabbitMqManager = rabbitMqManager;
        userMessageManager.onApplicationStart();

        final long maxUserId = 12;
        System.out.printf("Starting the application with %d simulated users%n", maxUserId);
        final List<Thread> threads = new ArrayList<>();
        for (long userId = 1; userId <= maxUserId; userId++) {
            final Thread thread = new Thread(new UserSimulator(userId, maxUserId, userMessageManager),
                    "user-thread-" + userId);
            threads.add(thread);
            thread.start();

            Thread.sleep(1000L);
        }

        // clean shutdown
        System.out.println("Running, strike ENTER to stop!");
        try (Scanner s = new Scanner(System.in)) {
            s.nextLine();
        }

        for (final Thread thread : threads) {
            thread.interrupt();
            thread.join();
        }

        System.out.print("Shutting down...");
        rabbitMqManager.stop();
        System.out.print("Bye!");
        System.exit(0);
    }
}

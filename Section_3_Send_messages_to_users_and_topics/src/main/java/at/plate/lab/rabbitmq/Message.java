package at.plate.lab.rabbitmq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "time_sent",
        "sender_id",
        "addressee_id",
        "topic",
        "subject",
        "content"
})
public class Message {

    @JsonProperty("time_sent")
    private Long timeSent;
    /**
     * (Required)
     */
    @JsonProperty("sender_id")
    private Long senderId;
    @JsonProperty("addressee_id")
    private Long addresseeId;
    @JsonProperty("topic")
    private String topic;
    /**
     * (Required)
     */
    @JsonProperty("subject")
    private String subject;
    /**
     * (Required)
     */
    @JsonProperty("content")
    private String content;

    @JsonProperty("time_sent")
    public Long getTimeSent() {
        return timeSent;
    }

    @JsonProperty("time_sent")
    public void setTimeSent(Long timeSent) {
        this.timeSent = timeSent;
    }

    /**
     * (Required)
     */
    @JsonProperty("sender_id")
    public Long getSenderId() {
        return senderId;
    }

    /**
     * (Required)
     */
    @JsonProperty("sender_id")
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    @JsonProperty("addressee_id")
    public Long getAddresseeId() {
        return addresseeId;
    }

    @JsonProperty("addressee_id")
    public void setAddresseeId(Long addresseeId) {
        this.addresseeId = addresseeId;
    }

    @JsonProperty("topic")
    public String getTopic() {
        return topic;
    }

    @JsonProperty("topic")
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * (Required)
     */
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    /**
     * (Required)
     */
    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * (Required)
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * (Required)
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

}

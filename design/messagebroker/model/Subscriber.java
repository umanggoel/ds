package design.messagebroker.model;

import design.messagebroker.public_interface.ISubscriber;

public class Subscriber implements ISubscriber {
    private Integer subscriberId;
    private Topic topic;
    private Integer offset;

    public Subscriber(Integer subscriberId, Topic topic) {
        this.subscriberId = subscriberId;
        this.topic = topic;
        this.offset = 0;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Integer subscriberId) {
        this.subscriberId = subscriberId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public void consume(Message message) {
        System.out.println("Subscriber " + subscriberId + " Topic : "+ getTopic().getTopicName() + " Consuming Method : "+ message.getMessage() );
    }
}

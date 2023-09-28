package design.messagebroker.model;

import design.messagebroker.public_interface.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String topicName;
    List<Message> messageList;
    List<ISubscriber> subscriberList;

    public Topic(String topicName) {
        this.topicName = topicName;
        this.messageList = new ArrayList<>();
        this.subscriberList = new ArrayList<>();
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(Message message) {
        this.messageList.add(message);
    }

    public List<ISubscriber> getSubscriberList() {
        return subscriberList;
    }

    public void addSubscriber(ISubscriber subscriber) {
        this.subscriberList.add(subscriber);
    }
}

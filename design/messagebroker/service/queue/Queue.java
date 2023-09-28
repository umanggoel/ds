package design.messagebroker.service.queue;

import design.messagebroker.model.Message;
import design.messagebroker.model.Topic;
import design.messagebroker.public_interface.IQueue;
import design.messagebroker.public_interface.ISubscriber;
import design.messagebroker.service.handler.MessageDispatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue implements IQueue {
    AtomicInteger integer = new AtomicInteger();
    Map<String, MessageDispatcher> topicMessageDispatcher;

    public Queue() {
        topicMessageDispatcher = new HashMap<>();
    }

    @Override
    public void publishMessage(Topic topic, String message) {
        Message m = new Message(integer.incrementAndGet(), message);
        topic.getMessageList().add(m);
        topicMessageDispatcher.get(topic.getTopicName()).publishMessageToSubscribers();
    }

    @Override
    public Topic createTopic(String topicName) {
        Topic topic = new Topic(topicName);
        topicMessageDispatcher.put(topicName, new MessageDispatcher(topic));
        return topic;
    }

    @Override
    public void subscribe(Topic topic, ISubscriber subscriber) {
        topic.addSubscriber(subscriber);
        //subscriber.setTopic(topic);
    }
}

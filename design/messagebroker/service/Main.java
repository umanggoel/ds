package design.messagebroker.service;

import design.messagebroker.model.Subscriber;
import design.messagebroker.model.Topic;
import design.messagebroker.public_interface.IQueue;
import design.messagebroker.public_interface.ISubscriber;
import design.messagebroker.service.queue.Queue;

public class Main {
    public static void main(String[] args) {
        final IQueue queue = new Queue();
        Topic topic1 = queue.createTopic("topic1");
        Topic topic2 = queue.createTopic("topic2");

        ISubscriber subscriber1 = new Subscriber(1, topic1);
        ISubscriber subscriber2 = new Subscriber(2, topic1);
        ISubscriber subscriber3 = new Subscriber(3, topic2);

        queue.subscribe(topic1, subscriber1);
        queue.subscribe(topic1, subscriber2);
        queue.subscribe(topic2, subscriber3);

        queue.publishMessage(topic1, "Hello");
        queue.publishMessage(topic1, "topic1");
        queue.publishMessage(topic2, "topic2");

    }
}

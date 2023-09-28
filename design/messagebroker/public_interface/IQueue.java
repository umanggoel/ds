package design.messagebroker.public_interface;

import design.messagebroker.model.Message;
import design.messagebroker.model.Topic;

public interface IQueue {
    void publishMessage(Topic topic, String message);
    Topic createTopic(String topic);
    void subscribe(Topic topic, ISubscriber subscriber);
}

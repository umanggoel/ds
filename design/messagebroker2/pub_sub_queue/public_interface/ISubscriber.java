package design.messagebroker2.pub_sub_queue.public_interface;

import design.messagebroker2.pub_sub_queue.model.Message;

public interface ISubscriber {

    String getId();
    void consume(Message message) throws InterruptedException;
}

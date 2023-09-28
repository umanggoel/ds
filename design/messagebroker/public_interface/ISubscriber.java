package design.messagebroker.public_interface;

import design.messagebroker.model.Message;
import design.messagebroker.model.Topic;

public interface ISubscriber {

    void consume(Message message);
    Integer getSubscriberId();
    Integer getOffset();
    void setOffset(Integer offset);
    Topic getTopic();

}

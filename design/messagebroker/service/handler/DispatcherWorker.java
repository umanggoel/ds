package design.messagebroker.service.handler;

import design.messagebroker.public_interface.ISubscriber;

public class DispatcherWorker implements Runnable{

    private ISubscriber subscriber;

    public DispatcherWorker(ISubscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void run() {
        while(subscriber.getOffset()<subscriber.getTopic().getMessageList().size()){
            subscriber.consume(subscriber.getTopic().getMessageList().get(subscriber.getOffset()));
            subscriber.setOffset(subscriber.getOffset()+1);
        }
    }
}

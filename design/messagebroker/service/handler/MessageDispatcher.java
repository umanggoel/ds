package design.messagebroker.service.handler;

import design.messagebroker.model.Subscriber;
import design.messagebroker.model.Topic;
import design.messagebroker.public_interface.ISubscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDispatcher {

    private Topic topic;

    Map<Integer, DispatcherWorker> subscriberDispatcherWorkerMap;

    public MessageDispatcher(Topic topic) {
        this.topic = topic;
        subscriberDispatcherWorkerMap = new HashMap<>();
    }

    public void publishMessageToSubscribers(){
        List<ISubscriber> subscriberList = topic.getSubscriberList();
        for(ISubscriber subscriber : subscriberList){
            if(!subscriberDispatcherWorkerMap.containsKey(subscriber.getSubscriberId())){
                DispatcherWorker dispatcherWorker = new DispatcherWorker(subscriber);
                subscriberDispatcherWorkerMap.put(subscriber.getSubscriberId(), dispatcherWorker);
                new Thread(dispatcherWorker).start();
            }
            //subscriberDispatcherWorkerMap.get(subscriber.getSubscriberId()).notify();
        }
    }
}

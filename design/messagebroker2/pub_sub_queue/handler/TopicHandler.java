package design.messagebroker2.pub_sub_queue.handler;

import design.messagebroker2.pub_sub_queue.model.Topic;
import design.messagebroker2.pub_sub_queue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    private final Topic topic;
    // Map<SubscriberId, SubscriberWorker>
    private final Map<String, TopicSubscriberWorker> subscriberWorkers;

    public TopicHandler( final Topic topic) {
        this.topic = topic;
        subscriberWorkers = new HashMap<>();
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber:topic.getSubscribers()) {
            startSubsriberWorker(topicSubscriber);
        }
    }

    public void startSubsriberWorker( final TopicSubscriber topicSubscriber) {
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            final TopicSubscriberWorker topicSubscriberWorker = new TopicSubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, topicSubscriberWorker);
            new Thread(topicSubscriberWorker).start();
        }
        final TopicSubscriberWorker topicSubscriberWorker = subscriberWorkers.get(subscriberId);
        topicSubscriberWorker.wakeUpIfNeeded();
    }
}

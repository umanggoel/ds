package com.consumers;

import com.commons.exceptions.NotificationTechnicalException;
import com.models.NotificationMessage;
import com.processor.ProcessorResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestProcessorConsumer {

    private String topic;
    private ProcessorResolver processorResolver;

    @Autowired
    public RequestProcessorConsumer(String topic, ProcessorResolver processorResolver) {
        this.topic = topic;
        this.processorResolver = processorResolver;
    }

    public void consumer(NotificationMessage message, String key,
                         String  partition, Long offset) {
        try {
            processorResolver.doProcessing(message);
        } catch (NotificationTechnicalException e) {
            e.printStackTrace();
        }
    }

    String getConsumerName() {
        return "request-processor-consumer";
    }
}

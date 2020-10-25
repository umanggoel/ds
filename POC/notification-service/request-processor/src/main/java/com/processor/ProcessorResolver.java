package com.processor;

import com.models.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProcessorResolver {

    List<Processor> processorList;

    @Autowired
    public ProcessorResolver(List<Processor> processorList) {
        this.processorList = processorList;
    }

    public void doProcessing(NotificationMessage notification) {
        processorList.stream().filter(e -> e.type() == notification.getMessageType()).forEach(e -> e.process(notification));
    }
}

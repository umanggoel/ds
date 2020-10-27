package com.processor;

import com.commons.exceptions.NotificationTechnicalException;
import com.models.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProcessorResolver {

    List<Processor> processorList;

    @Autowired
    public ProcessorResolver(List<Processor> processorList) {
        this.processorList = processorList;
    }

    public void doProcessing(NotificationMessage notification) throws NotificationTechnicalException {
        List<Processor> processors =  processorList.stream().filter(e -> e.type() == notification.getMessageType()).collect(toList());
                for(Processor e : processors){
                    e.process(notification);
                }
    }
}

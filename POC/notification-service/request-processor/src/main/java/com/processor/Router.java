package com.processor;

import com.commons.exceptions.NotificationTechnicalException;
import com.models.MessagePriorityEnum;
import com.models.NotificationMessage;
import com.queueprocessor.producer.NotificationLogger;

import java.util.HashMap;
import java.util.Map;

public class Router {

    private final NotificationLogger notificationLogger;
    Map<MessagePriorityEnum, String> queueMap = new HashMap<>();

    public Router(NotificationLogger notificationLogger) {
        this.notificationLogger = notificationLogger;
        queueMap.put(MessagePriorityEnum.HIGH ,"high");
        queueMap.put(MessagePriorityEnum.MEDIUM ,"Medium");
        queueMap.put(MessagePriorityEnum.LOW ,"low");
    }

    public void publishMessage(NotificationMessage message) throws NotificationTechnicalException {
        notificationLogger.log(message.getMessageId(), queueMap.get(message.getPriority()), message);
    }
}

package com.processor.regularprocessor;

import com.commons.exceptions.NotificationTechnicalException;
import com.models.NotificationMessage;
import com.models.MessageTypeEnum;
import com.processor.Processor;
import com.processor.Router;
import com.queueprocessor.producer.NotificationLogger;

import static com.models.MessageTypeEnum.REGULAR;

public class RegularNotificationProcessor implements Processor {

    private final NotificationLogger notificationLogger;
    private final Router router;

    public RegularNotificationProcessor(NotificationLogger notificationLogger, Router router) {
        this.notificationLogger = notificationLogger;
        this.router = router;
    }

    @Override
    public void process(NotificationMessage notification) throws NotificationTechnicalException {
        router.publishMessage(notification);
    }

    @Override
    public MessageTypeEnum type() {
        return REGULAR;
    }
}

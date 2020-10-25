package com.processor.scheduledprocessor;

import com.models.NotificationMessage;
import com.models.MessageTypeEnum;
import com.processor.Processor;
import com.processor.Router;
import com.processor.digestprocessor.DigestNotificationProcessor;
import com.repository.manager.ScheduledMessageRepositoryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.models.MessageTypeEnum.SCHEDULED;

public class ScheduledNotificationProcessor implements Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledNotificationProcessor.class);

    private final ScheduledMessageRepositoryManager scheduledMessageRepositoryManager;
    private final Router router;

    public ScheduledNotificationProcessor(ScheduledMessageRepositoryManager scheduledMessageRepositoryManager, Router router) {
        this.scheduledMessageRepositoryManager = scheduledMessageRepositoryManager;
        this.router = router;
    }

    @Override
    public void process(NotificationMessage notification) {
        if(notification.getScheduleTime() != null) {
            LOGGER.error("Notification is not a Scheduled type message");
        }

        Long currentTimestamp = System.currentTimeMillis();
        if(notification.getTtl() != null){
            notification.setTtl(notification.getScheduleTime());
            scheduledMessageRepositoryManager.save(notification);
        } else if(notification.getTtl() <= currentTimestamp) {
            router.publishMessage(notification);
        }
    }

    @Override
    public MessageTypeEnum type() {
        return SCHEDULED;
    }
}

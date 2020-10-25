package com.repository.manager;

import com.models.NotificationMessage;
import com.repository.models.NotificationMessageBO;
import com.repository.repository.ScheduledMessageRepository;
import org.springframework.core.convert.ConversionService;

public class ScheduledMessageRepositoryManager {

    private final ConversionService conversionService;
    private final ScheduledMessageRepository scheduledMessageRepository;

    public ScheduledMessageRepositoryManager(ConversionService conversionService, ScheduledMessageRepository scheduledMessageRepository) {
        this.conversionService = conversionService;
        this.scheduledMessageRepository = scheduledMessageRepository;
    }

    public void save(NotificationMessage notificationMessage){
        NotificationMessageBO notificationMessageBO = conversionService.convert(notificationMessage, NotificationMessageBO.class);
        scheduledMessageRepository.saveNotificationMessage(notificationMessageBO);
    }

    public NotificationMessage getNotification(String key){
        NotificationMessageBO notificationMessageBO = scheduledMessageRepository.getNotificationMessage(key);
        return conversionService.convert(notificationMessageBO, NotificationMessage.class);
    }
}

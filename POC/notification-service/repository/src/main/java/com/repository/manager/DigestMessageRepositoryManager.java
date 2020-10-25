package com.repository.manager;

import com.models.NotificationMessage;
import com.repository.models.NotificationMessageBO;
import com.repository.repository.DigestMessageRepository;
import org.springframework.core.convert.ConversionService;

public class DigestMessageRepositoryManager {

    private final ConversionService conversionService;
    private final DigestMessageRepository digestMessageRepository;

    public DigestMessageRepositoryManager(ConversionService conversionService, DigestMessageRepository digestMessageRepository) {
        this.conversionService = conversionService;
        this.digestMessageRepository = digestMessageRepository;
    }

    public void save(NotificationMessage notificationMessage){
        NotificationMessageBO notificationMessageBO = conversionService.convert(notificationMessage, NotificationMessageBO.class);
        digestMessageRepository.saveNotificationMessage(notificationMessageBO);
    }

    public NotificationMessage getNotification(String key){
       NotificationMessageBO notificationMessageBO = digestMessageRepository.getNotificationMessage(key);
       return conversionService.convert(notificationMessageBO, NotificationMessage.class);
    }
}

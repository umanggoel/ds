package com.repository.repository;

import com.repository.models.NotificationMessageBO;

public interface DigestMessageRepository {

    void saveNotificationMessage(NotificationMessageBO notificationMessage) ;

    NotificationMessageBO getNotificationMessage(String id) ;
}

package com.repository.converters;

import com.models.NotificationMessage;
import com.repository.models.NotificationMessageBO;
import org.springframework.core.convert.converter.Converter;

public class NotificationMessageToNotificationBOConverter implements Converter<NotificationMessage, NotificationMessageBO> {
    @Override
    public NotificationMessageBO convert(NotificationMessage message) {
        return null;
    }
}

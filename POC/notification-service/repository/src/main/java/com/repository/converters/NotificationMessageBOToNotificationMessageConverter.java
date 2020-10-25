package com.repository.converters;

import com.models.NotificationMessage;
import com.repository.models.NotificationMessageBO;
import org.springframework.core.convert.converter.Converter;

public class NotificationMessageBOToNotificationMessageConverter implements Converter<NotificationMessageBO, NotificationMessage> {
    @Override
    public NotificationMessage convert(NotificationMessageBO message) {
        return null;
    }
}

package com.notifications.converters;

import com.models.NotificationMessage;
import com.models.NotificationMode;
import com.notifications.models.NotificationRequest;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.UUID;

import static com.models.NotificationMode.newNotificationMode;
import static java.util.stream.Collectors.toList;

public class NotificationRequestToNotificationMessageConverter implements Converter<NotificationRequest, NotificationMessage> {

    @Override
    public NotificationMessage convert(NotificationRequest notificationRequest) {

        List<NotificationMode> notificationModes = notificationRequest.getNotificationModes()
                .stream().map(e ->{
                    return newNotificationMode()
                            .email(e.getEmail())
                            .mode(e.getMode())
                            .phoneNumber(e.getPhoneNumber())
                            .templateName(e.getTemplateName())
                            .build();
                }).collect(toList());

        return NotificationMessage.newNotificationMessage()
                .isDigest(notificationRequest.isDigest())
                .messageId(UUID.randomUUID().toString())
                .messageProperties(notificationRequest.getMessageProperties())
                .messageType(notificationRequest.getMessageType())
                .notificationModes(notificationModes)
                .originatorId(notificationRequest.getOriginatorId())
                .priority(notificationRequest.getPriority())
                .timestamp(notificationRequest.getTimestamp())
                .scheduleTime(notificationRequest.getScheduleTime())
                .build();
    }
}

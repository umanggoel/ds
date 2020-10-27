package com.notifications.controller;

import com.commons.exceptions.InvalidInputExpception;
import com.commons.exceptions.NotificationTechnicalException;
import com.models.NotificationMessage;
import com.notifications.models.NotificationRequest;
import com.queueprocessor.producer.NotificationLogger;
import com.validators.ValidatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
public class Controller {

    private final ValidatorManager validatorManager;
    private final ConversionService conversionService;
    private final NotificationLogger notificationLogger;
    private static final String QUEUE = "level1";

    @Autowired
    public Controller(ValidatorManager validator, ConversionService conversionService, NotificationLogger notificationLogger) {
        this.validatorManager = validator;
        this.conversionService = conversionService;
        this.notificationLogger = notificationLogger;
    }

    @PostMapping(value = "notification-service/v1/notifications")
    @ResponseStatus(ACCEPTED)
    public void publishNotifications(@RequestBody NotificationRequest notification) throws InvalidInputExpception, NotificationTechnicalException
    {
        NotificationMessage notificationMessage = conversionService.convert(notification, NotificationMessage.class);
        validatorManager.applyValidations(notificationMessage);
        notificationLogger.log(notificationMessage.getMessageId(), QUEUE, notificationMessage);
    }
}

package com.validators;

import com.commons.exceptions.InvalidInputExpception;
import com.models.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidatorManager {

    @Autowired
    List<NotificationValidator> validatorList;

    public void applyValidations(NotificationMessage notification) throws InvalidInputExpception {

        List<NotificationValidator> validators = validatorList.stream().filter(e -> e.serviceId().equals("generic-validator") || e.serviceId().equals(notification.getOriginatorId())).collect(Collectors.toList());
        for(NotificationValidator v : validators) {
            v.validate(notification);
        }
    }
}

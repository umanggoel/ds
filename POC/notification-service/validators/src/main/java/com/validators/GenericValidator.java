package com.validators;

import com.commons.exceptions.InvalidInputExpception;
import com.models.NotificationMessage;

public class GenericValidator implements NotificationValidator {

    @Override
    public void validate(NotificationMessage message) throws InvalidInputExpception
    {
    }

    @Override
    public String serviceId() {
        return "generic-validator";
    }
}

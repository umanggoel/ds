package com.validators;

import com.commons.exceptions.InvalidInputExpception;
import com.models.NotificationMessage;

public interface NotificationValidator {

    void validate(NotificationMessage message) throws InvalidInputExpception;

    String serviceId() ;
}

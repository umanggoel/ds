package com.validators;

import com.commons.exceptions.InvalidInputExpception;
import com.models.NotificationMessage;

import static com.models.MessageTypeEnum.DIGEST;
import static com.models.MessageTypeEnum.REGULAR;
import static com.models.MessageTypeEnum.SCHEDULED;

public class GenericNotificationModesValidator implements NotificationValidator {

    @Override
    public void validate(NotificationMessage message) throws InvalidInputExpception
    {
        if(message.getNotificationModes().size() == 0){
            throw new InvalidInputExpception("Notification Modes Cannot be emtpy","");
        }

        if(message.getNotificationModes().size() > 100){
            throw new InvalidInputExpception("Notification Modes Cannot be more then 100","");
        }

        if(message.getMessageType() == DIGEST && message.getNotificationModes().size() != 1 && message.getNotificationModes().get(0).getEmail() == null) {
                throw new InvalidInputExpception("Invalid notification modes for digest message", "");
        } else if(message.getMessageType() == SCHEDULED && message.getScheduleTime() == null) {
            throw new InvalidInputExpception("Scheduled time cannot be null", "");
        }
    }

    @Override
    public String serviceId() {
        return "generic-validator";
    }
}

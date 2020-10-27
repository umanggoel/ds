package com.processor;

import com.commons.exceptions.NotificationTechnicalException;
import com.models.NotificationMessage;
import com.models.MessageTypeEnum;

public interface Processor {

    void process(NotificationMessage notification) throws NotificationTechnicalException;

    MessageTypeEnum type();
}

package com.processor;

import com.models.NotificationMessage;
import com.models.MessageTypeEnum;

public interface Processor {

    void process(NotificationMessage notification);

    MessageTypeEnum type();
}

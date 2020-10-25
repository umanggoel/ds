package com.consumers.email;

import com.models.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailConsumer {


    public void consumer(NotificationMessage message, String key,
                         String  partition, Long offset) {

    }

    String getConsumerName() {
        return "EMAIL-CONSUMER";
    }
}

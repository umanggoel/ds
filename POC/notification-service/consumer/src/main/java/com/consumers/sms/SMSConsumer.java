package com.consumers.sms;

import com.models.NotificationMessage;

public class SMSConsumer {



    public void consumer(NotificationMessage message, String key,
                         String  partition, Long offset) {

    }

    String getConsumerName() {
        return "SMS-CONSUMER";
    }

}

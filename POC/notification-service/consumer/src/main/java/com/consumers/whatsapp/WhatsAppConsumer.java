package com.consumers.whatsapp;

import com.models.NotificationMessage;

public class WhatsAppConsumer {

    public void consumer(NotificationMessage message, String key,
                         String  partition, Long offset) {

    }

    String getConsumerName() {
        return "Whatsapp-CONSUMER";
    }

}

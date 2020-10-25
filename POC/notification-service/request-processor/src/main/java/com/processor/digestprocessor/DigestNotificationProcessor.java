package com.processor.digestprocessor;

import com.models.NotificationMessage;
import com.models.MessageTypeEnum;
import com.processor.Processor;
import com.processor.Router;
import com.repository.manager.DigestMessageRepositoryManager;
import com.repository.repository.DigestMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static com.models.MessageTypeEnum.DIGEST;
import static java.util.Arrays.asList;

public class DigestNotificationProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DigestNotificationProcessor.class);

    private final DigestMessageRepositoryManager digestMessageRepositoryManager;
    private final Router router;
    private final static int digestTimeinMillis = 5678;

    public DigestNotificationProcessor(DigestMessageRepositoryManager digestMessageRepositoryManager, Router router) {
        this.digestMessageRepositoryManager = digestMessageRepositoryManager;
        this.router = router;
    }

    @Override
    public void process(NotificationMessage notification) {
        if(!notification.isDigest()) {
            LOGGER.error("Notification is not a digest type message");
        }

        Long currentTimestamp = System.currentTimeMillis();

        if(notification.getTtl() != null){
            String key = notification.getNotificationModes().get(0).getEmail();
            NotificationMessage messageToSave = digestMessageRepositoryManager.getNotification(key);
            if(messageToSave != null) {
                messageToSave.getDigestMessages().add(notification);
            }else{
                messageToSave.setTtl(currentTimestamp+digestTimeinMillis);
                messageToSave.setDigestMessages(asList(notification));
            }

            digestMessageRepositoryManager.save(messageToSave);

        } else if(notification.getTtl() <= currentTimestamp) {
            router.publishMessage(notification);
        }
    }

    @Override
    public MessageTypeEnum type() {
        return DIGEST;
    }
}

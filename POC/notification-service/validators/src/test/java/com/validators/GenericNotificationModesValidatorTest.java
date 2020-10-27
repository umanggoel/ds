package com.validators;

import com.commons.exceptions.InvalidInputExpception;
import com.models.NotificationMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.models.MessageTypeEnum.DIGEST;
import static com.models.MessageTypeEnum.SCHEDULED;

@RunWith(MockitoJUnitRunner.class)
public class GenericNotificationModesValidatorTest {

    private GenericNotificationModesValidator validator = new GenericNotificationModesValidator();

    @Test
    public void testValidateNoModes(){

    }

    @Test
    public void testValidateModesExceedingAllowedCount(){

    }

    @Test
    public void testValidateModesDigestMessage(){

    }

    @Test
    public void testValidateModesScheduledMessage(){

    }

}

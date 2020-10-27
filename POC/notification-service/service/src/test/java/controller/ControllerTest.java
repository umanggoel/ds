package controller;

import com.commons.exceptions.InvalidInputExpception;
import com.commons.exceptions.NotificationTechnicalException;
import com.models.NotificationMessage;
import com.notifications.controller.Controller;
import com.notifications.models.NotificationRequest;
import com.queueprocessor.producer.NotificationLogger;
import com.validators.ValidatorManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

import static com.models.NotificationMessage.newNotificationMessage;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Mock private  ValidatorManager validatorManager;
    @Mock private  ConversionService conversionService;
    @Mock private  NotificationLogger notificationLogger;

    @InjectMocks private Controller controller;


    @Test
    public void testpublishNotificationsValidationPassed() throws Exception
    {
        when(conversionService.convert(any(NotificationRequest.class), any(Class.class))).thenReturn(newNotificationMessage().messageId("2134").build());
        doNothing().when(validatorManager).applyValidations(any(NotificationMessage.class));
        doNothing().when(notificationLogger).log(any(String.class),any(String.class), any(NotificationMessage.class));

        controller.publishNotifications(new NotificationRequest());
        verify(notificationLogger,times(1)).log(anyString(),anyString(), any(NotificationMessage.class));
    }

    @Test(expected = InvalidInputExpception.class)
    public void testpublishNotificationsValidationFailed() throws Exception
    {
        when(conversionService.convert(any(NotificationRequest.class), any(Class.class))).thenReturn(newNotificationMessage().messageId("2134").build());
        doThrow(new InvalidInputExpception("invLID","")).when(validatorManager).applyValidations(any(NotificationMessage.class));
        NotificationRequest request = new NotificationRequest();
        request.setMessageId("1221");
        controller.publishNotifications(request);
    }

    @Test(expected = NotificationTechnicalException.class)
    public void testpublishNotificationsNotificationPushfailed() throws Exception
    {
        when(conversionService.convert(any(NotificationRequest.class), any(Class.class))).thenReturn(newNotificationMessage().messageId("2134").build());
        doNothing().when(validatorManager).applyValidations(any(NotificationMessage.class));
        doThrow(new NotificationTechnicalException()).when(notificationLogger).log(any(String.class),any(String.class), any(NotificationMessage.class));
        NotificationRequest request = new NotificationRequest();
        request.setMessageId("1221");
        controller.publishNotifications(request);
    }
}

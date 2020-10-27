import com.commons.exceptions.NotificationTechnicalException;
import com.models.NotificationMessage;
import com.processor.Router;
import com.processor.scheduledprocessor.ScheduledNotificationProcessor;
import com.repository.manager.ScheduledMessageRepositoryManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.models.NotificationMessage.newNotificationMessage;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScheduledNotificationProcessorTest {

    @Mock private  ScheduledMessageRepositoryManager scheduledMessageRepositoryManager;
    @Mock private  Router router;
    @InjectMocks private ScheduledNotificationProcessor scheduledNotificationProcessor;

    @Test
    public void testProcessInvalidMessage() throws NotificationTechnicalException {
        NotificationMessage request = newNotificationMessage().build();
        scheduledNotificationProcessor.process(request);
    }

    @Test
    public void testProcessMessageWithTTLExpiredNOExceptionWhilePublishing() throws NotificationTechnicalException {
        NotificationMessage request = newNotificationMessage().ttl(1233l).build();
        doNothing().when(router).publishMessage(any(NotificationMessage.class));
        scheduledNotificationProcessor.process(request);
        verify(router, times(1)).publishMessage(any(NotificationMessage.class));
    }

    @Test(expected = NotificationTechnicalException.class)
    public void testProcessMessageWithTTLExpiredExceptionWhilePublishing() throws NotificationTechnicalException {
        NotificationMessage request = newNotificationMessage().ttl(1233l).build();
        doThrow(new NotificationTechnicalException()).when(router).publishMessage(any(NotificationMessage.class));
        scheduledNotificationProcessor.process(request);
    }

    @Test
    public void testProcessMessageWithoutTTL() throws NotificationTechnicalException {
        NotificationMessage request = newNotificationMessage().build();
        doNothing().when(scheduledMessageRepositoryManager).save(any(NotificationMessage.class));
        scheduledNotificationProcessor.process(request);
        verify(scheduledMessageRepositoryManager, times(1)).save(any(NotificationMessage.class));
    }


}

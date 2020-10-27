import com.commons.exceptions.NotificationTechnicalException;
import com.models.NotificationMessage;
import com.models.NotificationMode;
import com.processor.Router;
import com.processor.digestprocessor.DigestNotificationProcessor;
import com.repository.manager.DigestMessageRepositoryManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.models.NotificationMessage.newNotificationMessage;
import static com.models.NotificationMode.newNotificationMode;
import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DigestNotificationProcessorTest {

    @Mock
    private DigestMessageRepositoryManager digestMessageRepositoryManager;
    @Mock
    private Router router;
    @InjectMocks
    private DigestNotificationProcessor processor;

    @Test
    public void testProcessInvalidMessage() throws NotificationTechnicalException {
        NotificationMessage request = newNotificationMessage().build();
        processor.process(request);
        verify(digestMessageRepositoryManager, times(0)).save(any(NotificationMessage.class));
    }

    @Test
    public void testProcessMessageWithTTLExpiredNOExceptionWhilePublishing() throws NotificationTechnicalException {
        NotificationMessage request = newNotificationMessage().isDigest(true).ttl(1233l).build();
        doNothing().when(router).publishMessage(any(NotificationMessage.class));
        processor.process(request);
        verify(router, times(1)).publishMessage(any(NotificationMessage.class));
    }

    @Test(expected = NotificationTechnicalException.class)
    public void testProcessMessageWithTTLExpiredExceptionWhilePublishing() throws NotificationTechnicalException {
        NotificationMessage request = newNotificationMessage().isDigest(true).ttl(1233l).build();
        doThrow(new NotificationTechnicalException()).when(router).publishMessage(any(NotificationMessage.class));
        processor.process(request);
    }

    @Test
    public void testProcessMessageWithoutTTLNewDigest() throws NotificationTechnicalException {
        NotificationMode notificationMode = newNotificationMode().email("weee").build();
        NotificationMessage request = newNotificationMessage().isDigest(true).notificationModes(asList(notificationMode)).build();
        doNothing().when(digestMessageRepositoryManager).save(any(NotificationMessage.class));
        when(digestMessageRepositoryManager.getNotification(any(String.class))).thenReturn(null);
        processor.process(request);
        verify(digestMessageRepositoryManager, times(1)).save(any(NotificationMessage.class));
    }

    @Test
    public void testProcessMessageWithoutTTLOldDigest() throws NotificationTechnicalException {
        NotificationMode notificationMode = newNotificationMode().email("weee").build();
        NotificationMessage request = newNotificationMessage().isDigest(true).notificationModes(asList(notificationMode)).build();
        doNothing().when(digestMessageRepositoryManager).save(any(NotificationMessage.class));
        when(digestMessageRepositoryManager.getNotification(any(String.class))).thenReturn(newNotificationMessage().build());
        processor.process(request);
        verify(digestMessageRepositoryManager, times(1)).save(any(NotificationMessage.class));
    }
}

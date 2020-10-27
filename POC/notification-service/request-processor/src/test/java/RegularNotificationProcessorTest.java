import com.commons.exceptions.NotificationTechnicalException;
import com.models.NotificationMessage;
import com.processor.Router;
import com.processor.regularprocessor.RegularNotificationProcessor;
import com.queueprocessor.producer.NotificationLogger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.models.NotificationMessage.newNotificationMessage;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class RegularNotificationProcessorTest {

    @Mock
    private NotificationLogger notificationLogger;
    @Mock
    private Router router;
    @InjectMocks
    private RegularNotificationProcessor regularNotificationProcessor;

    @Test
    public void testPublishNotificationSuccess() throws NotificationTechnicalException {
        doNothing().when(router).publishMessage(any(NotificationMessage.class));
        regularNotificationProcessor.process(newNotificationMessage().build());
    }

    @Test(expected = NotificationTechnicalException.class)
    public void testPublishNotificationException() throws NotificationTechnicalException {
        doThrow(new NotificationTechnicalException()).when(router).publishMessage(any(NotificationMessage.class));
        regularNotificationProcessor.process(newNotificationMessage().build());
    }

}

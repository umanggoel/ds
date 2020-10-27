package converter;

import com.models.MessageTypeEnum;
import com.models.NotificationMessage;
import com.notifications.converters.NotificationRequestToNotificationMessageConverter;
import com.notifications.models.NotificationMode;
import com.notifications.models.NotificationRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.models.MessageTypeEnum.DIGEST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class NotificationRequestToNotificationMessageConverterTest {

    private NotificationRequestToNotificationMessageConverter converter = new NotificationRequestToNotificationMessageConverter();

    @Test
    public void testConvertWithNullNotificationModes(){

        NotificationRequest request = new NotificationRequest();
        request.setDigest(true);
        request.setMessageType(DIGEST);
        NotificationMessage result = converter.convert(request);
        assertNotNull(result);
        assertEquals(request.isDigest(), result.isDigest());
        assertEquals(request.getMessageType(), result.getMessageType());
    }

    @Test
    public void testConvertWithNotNullNotificationModes(){
        NotificationRequest request = new NotificationRequest();
        request.setDigest(true);
        request.setMessageType(DIGEST);

        List<NotificationMode> notificationModes = new ArrayList<>();
        notificationModes.add(new NotificationMode());

        request.setNotificationModes(notificationModes);
        NotificationMessage result = converter.convert(request);
        assertNotNull(result);
        assertEquals(request.isDigest(), result.isDigest());
        assertEquals(request.getMessageType(), result.getMessageType());
        assertEquals(request.getNotificationModes().size(),result.getNotificationModes().size());
    }
}

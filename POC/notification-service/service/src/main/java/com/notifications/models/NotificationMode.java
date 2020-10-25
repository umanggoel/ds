package com.notifications.models;

import com.models.NotificationModeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationMode {

    private NotificationModeEnum mode;
    private String templateName;
    private String phoneNumber;
    private String email;

    @Override
    public String toString() {
        return "NotificationMode{" +
                "mode=" + mode +
                ", templateName='" + templateName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

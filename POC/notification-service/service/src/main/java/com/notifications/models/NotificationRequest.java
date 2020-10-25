package com.notifications.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.models.MessagePriorityEnum;
import com.models.MessageTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationRequest {

        @NonNull
        private MessagePriorityEnum priority;
        @NonNull
        private MessageTypeEnum messageType;
        @NonNull
        private String originatorId;
        @NonNull
        private List<NotificationMode> notificationModes;
        @NonNull
        private Map<String, String> messageProperties;
        private Long scheduleTime;
        private boolean isDigest;
        private String messageId;
        @NonNull
        private Long timestamp;

        @Override
        public String toString() {
                return "NotificationRequest{" +
                        "priority=" + priority +
                        ", messageType=" + messageType +
                        ", originatorId='" + originatorId + '\'' +
                        ", notificationModes=" + notificationModes +
                        ", messageProperties=" + messageProperties +
                        ", scheduleTime=" + scheduleTime +
                        ", isDigest=" + isDigest +
                        ", messageId='" + messageId + '\'' +
                        ", timestamp=" + timestamp +
                        '}';
        }
}

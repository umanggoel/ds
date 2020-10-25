package com.repository.models;

import com.models.MessagePriorityEnum;
import com.models.MessageTypeEnum;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class NotificationMessageBO implements Serializable {

    private MessagePriorityEnum priority;
    private MessageTypeEnum messageType;
    private String originatorId;
    private List<NotificationModeBO> notificationModes;
    private Map<String, String> messageProperties;
    private Long scheduleTime;
    private boolean isDigest;
    private String messageId;
    private Long timestamp;

    private NotificationMessageBO(Builder builder) {
        this.priority = builder.priority;
        this.messageType = builder.messageType;
        this.originatorId = builder.originatorId;
        this.notificationModes = builder.notificationModes;
        this.messageProperties = builder.messageProperties;
        this.scheduleTime = builder.scheduleTime;
        this.isDigest = builder.isDigest;
        this.messageId = builder.messageId;
        this.timestamp = builder.timestamp;
    }

    public static Builder newNotificationMessageBO() {
        return new Builder();
    }

    public MessagePriorityEnum getPriority() {
        return priority;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public String getOriginatorId() {
        return originatorId;
    }

    public List<NotificationModeBO> getNotificationModes() {
        return notificationModes;
    }

    public Map<String, String> getMessageProperties() {
        return messageProperties;
    }

    public Long getScheduleTime() {
        return scheduleTime;
    }

    public boolean isDigest() {
        return isDigest;
    }

    public String getMessageId() {
        return messageId;
    }

    public Long getTimestamp() {
        return timestamp;
    }


    public static final class Builder {
        private MessagePriorityEnum priority;
        private MessageTypeEnum messageType;
        private String originatorId;
        private List<NotificationModeBO> notificationModes;
        private Map<String, String> messageProperties;
        private Long scheduleTime;
        private boolean isDigest;
        private String messageId;
        private Long timestamp;

        private Builder() {
        }

        public NotificationMessageBO build() {
            return new NotificationMessageBO(this);
        }

        public Builder priority(MessagePriorityEnum priority) {
            this.priority = priority;
            return this;
        }

        public Builder messageType(MessageTypeEnum messageType) {
            this.messageType = messageType;
            return this;
        }

        public Builder originatorId(String originatorId) {
            this.originatorId = originatorId;
            return this;
        }

        public Builder notificationModes(List<NotificationModeBO> notificationModes) {
            this.notificationModes = notificationModes;
            return this;
        }

        public Builder messageProperties(Map<String, String> messageProperties) {
            this.messageProperties = messageProperties;
            return this;
        }

        public Builder scheduleTime(Long scheduleTime) {
            this.scheduleTime = scheduleTime;
            return this;
        }

        public Builder isDigest(boolean isDigest) {
            this.isDigest = isDigest;
            return this;
        }

        public Builder messageId(String messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }
    }

    @Override
    public String toString() {
        return "NotificationMessageBO{" +
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


package com.models;

import java.util.List;
import java.util.Map;

public class NotificationMessage {

    private MessagePriorityEnum priority;
    private MessageTypeEnum messageType;
    private String originatorId;
    private List<NotificationMode> notificationModes;
    private Map<String, String> messageProperties;
    private Long scheduleTime;
    private boolean isDigest;
    private String messageId;
    private Long timestamp;
    private Long ttl;
    private List<NotificationMessage> digestMessages;

    private NotificationMessage(Builder builder) {
        this.priority = builder.priority;
        this.messageType = builder.messageType;
        this.originatorId = builder.originatorId;
        this.notificationModes = builder.notificationModes;
        this.messageProperties = builder.messageProperties;
        this.scheduleTime = builder.scheduleTime;
        this.isDigest = builder.isDigest;
        this.messageId = builder.messageId;
        this.timestamp = builder.timestamp;
        this.ttl = builder.ttl;
        this.digestMessages = builder.digestMessages;
    }

    public static Builder newNotificationMessage() {
        return new Builder();
    }

    public List<NotificationMessage> getDigestMessages() {
        return digestMessages;
    }

    public void setDigestMessages(List<NotificationMessage> digestMessages) {
        this.digestMessages = digestMessages;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
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

    public List<NotificationMode> getNotificationModes() {
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

    public Long getTtl() {
        return ttl;
    }


    public static final class Builder {
        private MessagePriorityEnum priority;
        private MessageTypeEnum messageType;
        private String originatorId;
        private List<NotificationMode> notificationModes;
        private Map<String, String> messageProperties;
        private Long scheduleTime;
        private boolean isDigest;
        private String messageId;
        private Long timestamp;
        private Long ttl;
        private List<NotificationMessage> digestMessages;

        private Builder() {
        }

        public NotificationMessage build() {
            return new NotificationMessage(this);
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

        public Builder notificationModes(List<NotificationMode> notificationModes) {
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

        public Builder ttl(Long ttl) {
            this.ttl = ttl;
            return this;
        }

        public Builder digestMessages(List<NotificationMessage> digestMessages) {
            this.digestMessages = digestMessages;
            return this;
        }
    }

    @Override
    public String toString() {
        return "NotificationMessage{" +
                "priority=" + priority +
                ", messageType=" + messageType +
                ", originatorId='" + originatorId + '\'' +
                ", notificationModes=" + notificationModes +
                ", messageProperties=" + messageProperties +
                ", scheduleTime=" + scheduleTime +
                ", isDigest=" + isDigest +
                ", messageId='" + messageId + '\'' +
                ", timestamp=" + timestamp +
                ", ttl=" + ttl +
                ", digestMessages=" + digestMessages +
                '}';
    }
}

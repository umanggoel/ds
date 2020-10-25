package com.models;

public class NotificationMode {

    private NotificationModeEnum mode;
    private String templateName;
    private String phoneNumber;
    private String email;

    private NotificationMode(Builder builder) {
        this.mode = builder.mode;
        this.templateName = builder.templateName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
    }

    public static Builder newNotificationMode() {
        return new Builder();
    }

    public NotificationModeEnum getMode() {
        return mode;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "NotificationMode{" +
                "mode=" + mode +
                ", templateName='" + templateName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class Builder {
        private NotificationModeEnum mode;
        private String templateName;
        private String phoneNumber;
        private String email;

        private Builder() {
        }

        public NotificationMode build() {
            return new NotificationMode(this);
        }

        public Builder mode(NotificationModeEnum mode) {
            this.mode = mode;
            return this;
        }

        public Builder templateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
    }
}

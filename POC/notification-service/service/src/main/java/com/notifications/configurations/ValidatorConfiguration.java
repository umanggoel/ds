package com.notifications.configurations;

import com.sun.org.apache.xerces.internal.impl.validation.ValidationManager;
import com.validators.GenericValidator;
import com.validators.NotificationValidator;
import com.validators.UserServiceValidator;
import com.validators.ValidatorManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfiguration {

    @Bean
    public NotificationValidator genericValidator() {
        return new GenericValidator();
    }

    @Bean
    public NotificationValidator userServiceValidator() {
        return new UserServiceValidator();
    }

    @Bean
    public ValidatorManager validatorManager() {
        return new ValidatorManager();
    }

}

package com.notifications.configurations;

import com.repository.manager.DigestMessageRepositoryManager;
import com.repository.manager.ScheduledMessageRepositoryManager;
import com.repository.repository.DigestMessageRepository;
import com.repository.repository.DigestMessageRepositoryImpl;
import com.repository.repository.ScheduledMessageRepository;
import com.repository.repository.ScheduledMessageRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class RepositoryConfigurations {

    @Bean
    public DigestMessageRepositoryManager digestMessageRepositoryManager(ConversionService conversionService, DigestMessageRepository digestMessageRepository) {
        return new DigestMessageRepositoryManager(conversionService, digestMessageRepository);
    }

    @Bean
    public ScheduledMessageRepositoryManager scheduledMessageRepositoryManager(ConversionService conversionService, ScheduledMessageRepository scheduledMessageRepository) {
        return new ScheduledMessageRepositoryManager(conversionService, scheduledMessageRepository);
    }

    @Bean
    public DigestMessageRepository digestMessageRepository() {
        return new DigestMessageRepositoryImpl();
    }

    @Bean
    public ScheduledMessageRepository scheduledMessageRepository() {
        return new ScheduledMessageRepositoryImpl();
    }
}

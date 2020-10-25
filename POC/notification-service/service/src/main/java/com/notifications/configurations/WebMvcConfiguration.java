package com.notifications.configurations;

import com.notifications.converters.NotificationRequestToNotificationMessageConverter;
import com.processor.Processor;
import com.processor.ProcessorResolver;
import com.processor.Router;
import com.processor.digestprocessor.DigestNotificationProcessor;
import com.processor.regularprocessor.RegularNotificationProcessor;
import com.processor.scheduledprocessor.ScheduledNotificationProcessor;
import com.queueprocessor.producer.NotificationLogger;
import com.repository.converters.NotificationMessageBOToNotificationMessageConverter;
import com.repository.converters.NotificationMessageToNotificationBOConverter;
import com.repository.manager.DigestMessageRepositoryManager;
import com.repository.manager.ScheduledMessageRepositoryManager;
import com.repository.repository.DigestMessageRepository;
import com.repository.repository.ScheduledMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableCaching
@EnableScheduling
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new NotificationRequestToNotificationMessageConverter());
        registry.addConverter(new NotificationMessageBOToNotificationMessageConverter());
        registry.addConverter(new NotificationMessageToNotificationBOConverter());
    }

    @Bean
    public NotificationLogger notificationLogger() {
        return  new NotificationLogger();
    }


    @Bean
    public ProcessorResolver processorResolver(List<Processor> processors) {
        return new ProcessorResolver(processors);
    }

    @Bean
    public Router router(NotificationLogger logger){
        return new Router(logger);
    }

    @Bean
    public ScheduledNotificationProcessor scheduledNotificationProcessor(ScheduledMessageRepositoryManager scheduledMessageRepositoryManager, Router router) {
        return new ScheduledNotificationProcessor(scheduledMessageRepositoryManager, router);
    }

    @Bean
    public RegularNotificationProcessor regularNotificationProcessor(NotificationLogger notificationLogger, Router router) {
        return new RegularNotificationProcessor(notificationLogger, router);
    }

    @Bean
    public DigestNotificationProcessor digestNotificationProcessor(DigestMessageRepositoryManager digestMessageRepositoryManager, Router router) {
        return new DigestNotificationProcessor( digestMessageRepositoryManager, router);
    }


}



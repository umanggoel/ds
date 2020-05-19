package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

import reactor.ipc.netty.NettyContext;

@Configuration
@ComponentScan
@EnableAsync
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class Application {

    @Value("${server.port:8080}")
    private int port = 8080;

    public static void main(String[] args) throws Exception {
    			try  {
    				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
                context.getBean(NettyContext.class).onClose().block();
            }catch(Exception e) {
            	
            }
    }

}
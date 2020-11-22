package com.example.scopum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@EnableScheduling

public class ScopumBotApplication {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(ScopumBotApplication.class, args);
    }
}

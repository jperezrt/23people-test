package com.twentythreepeople.ms.app.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class testApplication {
    public static void main(String args[]) {
        SpringApplication.run(testApplication.class, args);
    }
}

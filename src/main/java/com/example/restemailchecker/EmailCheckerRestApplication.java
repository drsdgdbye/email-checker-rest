package com.example.restemailchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties") //store login data to db
public class EmailCheckerRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailCheckerRestApplication.class, args);
    }
}

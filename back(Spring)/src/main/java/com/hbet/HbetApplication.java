package com.hbet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HbetApplication {

    public static void main(String[] args) {
        SpringApplication.run(HbetApplication.class, args);
    }

}

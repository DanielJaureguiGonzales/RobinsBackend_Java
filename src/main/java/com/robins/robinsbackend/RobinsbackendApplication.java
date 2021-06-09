package com.robins.robinsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RobinsbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobinsbackendApplication.class, args);
    }

}

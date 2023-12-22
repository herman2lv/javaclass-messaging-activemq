package com.hrm.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppAlpha {

    public static void main(String[] args) {
        SpringApplication.run(AppAlpha.class, args);
    }

}

package com.tjcloud.match;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tjcloud")
public class TjcloudMatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TjcloudMatchApplication.class, args);
    }

}

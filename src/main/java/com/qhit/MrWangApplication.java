package com.qhit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MrWangApplication {

    public static void main(String[] args) {
        SpringApplication.run(MrWangApplication.class, args);
    }

}

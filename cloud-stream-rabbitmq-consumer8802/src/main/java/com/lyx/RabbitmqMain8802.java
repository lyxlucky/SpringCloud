package com.lyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liao 2021/9/29
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitmqMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqMain8802.class);
    }
}

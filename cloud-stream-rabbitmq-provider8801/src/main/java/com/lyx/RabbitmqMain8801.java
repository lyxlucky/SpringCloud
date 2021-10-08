package com.lyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liao 2021/9/29
 */
@EnableEurekaClient
@SpringBootApplication
public class RabbitmqMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqMain8801.class);
    }

}

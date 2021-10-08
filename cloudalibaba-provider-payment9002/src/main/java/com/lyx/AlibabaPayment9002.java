package com.lyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liao 2021/9/29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9002.class);
    }
}

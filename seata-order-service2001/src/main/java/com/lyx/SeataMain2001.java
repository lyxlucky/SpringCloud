package com.lyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liao 2021/10/3
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataMain2001.class,args);
    }
}

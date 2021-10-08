package com.lyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liao 2021/2/1
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lyx.dao")
public class Application8002 {
    public static void main(String[] args) {
        SpringApplication.run(Application8002.class,args);
    }
}

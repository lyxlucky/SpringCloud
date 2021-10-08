package com.lyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author liao 2021/9/26
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoard9001Main {
    public static void main(String[] args) {
        SpringApplication.run(DashBoard9001Main.class);
    }
}

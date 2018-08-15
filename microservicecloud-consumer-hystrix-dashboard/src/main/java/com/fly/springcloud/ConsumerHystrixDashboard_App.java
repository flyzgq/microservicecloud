package com.fly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启图形化监控
public class ConsumerHystrixDashboard_App {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboard_App.class, args);
    }
}

package com.fly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableEurekaClient //客户端
@EnableFeignClients(basePackages = {"com.fly.springcloud"})
public class DeptCusumer18003_feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptCusumer18003_feign_App.class, args);
    }

}

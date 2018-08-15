package com.fly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 主启动类
 */
@SpringBootApplication
@ServletComponentScan
@EnableEurekaClient  //该服务启动后自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //对hystrix熔断机制的支持
public class DeptProvider9001_hystrix_App
{
    public static void main( String[] args )
    {
        SpringApplication.run(DeptProvider9001_hystrix_App.class, args);
    }
}

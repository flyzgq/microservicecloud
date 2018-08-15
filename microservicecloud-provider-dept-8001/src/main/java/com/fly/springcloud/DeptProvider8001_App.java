package com.fly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类
 */
@SpringBootApplication
@ServletComponentScan
@EnableEurekaClient  //该服务启动后自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
public class DeptProvider8001_App
{
    public static void main( String[] args )
    {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}

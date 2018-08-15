package com.fly.springcloud.controller;
import com.fly.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {

//    public static final String REST_URL_PREFIX= "http://localhost:8001/server/dept";
      public static final String REST_URL_PREFIX= "http://MICROSERVICECLOUD-DEPT/server/dept";//MICROSERVICECLOUD-DEPT代表微服务的名称
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/add",dept, Boolean.class);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/get/" + id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/list", List.class);
    }

    @PostMapping("/update")
    public boolean update(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/update",dept, Boolean.class);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/discovery", Object.class);
    }
}

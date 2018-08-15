package com.fly.springcloud.service;

import com.fly.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptServiceFallbackFactory.class)
public interface DeptClientService {

    @PostMapping("/server/dept/add")
    boolean add(Dept dept);


    @GetMapping("/server/dept/get/{id}")
    Dept get(@PathVariable("id") long id);

    @GetMapping("/server/dept/list")
    List<Dept> list();


    @PostMapping("/server/dept/update")
    boolean update(Dept dept);

    @GetMapping("/server/dept/discovery")
    Object discovery();
}

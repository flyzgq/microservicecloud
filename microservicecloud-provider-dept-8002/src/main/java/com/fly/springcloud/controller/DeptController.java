package com.fly.springcloud.controller;

import com.fly.springcloud.entity.Dept;
import com.fly.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fly
 * @date 2018/8/5 20:07
 * @description
 **/
@RestController
@RequestMapping("/server/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;


    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dd")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Dept dept){
        return deptService.update(dept);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println("***********************" + services);
        List<ServiceInstance> instanceList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance ele:instanceList) {
            System.out.println(ele.getServiceId() + "\t" + ele.getHost()
                    + "\t" + ele.getPort() + "\t" + ele.getUri());
        }
        return this.client;
    }
}

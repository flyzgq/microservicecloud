package com.fly.springcloud.controller;

import com.fly.springcloud.entity.Dept;
import com.fly.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "processHystrix_Get")//一旦调用服务方法失败并抛出了错误信息，会自动调用@HystrixCommand标注的fallbackMethod调用类中的指定方法
    public Dept get(@PathVariable("id") long id){
        Dept dept = deptService.get(id);
        if(null == dept){
            throw new RuntimeException("该ID: " + id + "没有对应的信息");
        }

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") long id){
        return new Dept().setDeptno(id).setDname("该id "+ id + "没有对应的信息， null -- @hysrtrixCommand")
                .setDb_source("no this database in MYSSQl");
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

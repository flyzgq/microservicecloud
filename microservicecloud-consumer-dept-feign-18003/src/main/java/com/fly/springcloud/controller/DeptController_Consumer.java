package com.fly.springcloud.controller;
import com.fly.springcloud.entity.Dept;
import com.fly.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service ;

    @PostMapping("/add")
    public boolean add(Dept dept){
        return this.service.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") long id){
        return this.service.get(id);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public List<Dept> list(){
        return this.service.list();
    }

    @PostMapping("/update")
    public boolean update(Dept dept){
        return this.service.update(dept);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        return this.service.discovery();
    }
}

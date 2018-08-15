package com.fly.springcloud.service;

import com.fly.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id).setDname("该id "+ id + "没有对应的信息， null -- @hysrtrixCommand")
                        .setDb_source("no this database in MYSSQl");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean update(Dept dept) {
                return false;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}

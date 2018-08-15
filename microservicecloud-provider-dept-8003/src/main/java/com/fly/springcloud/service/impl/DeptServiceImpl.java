package com.fly.springcloud.service.impl;

import com.fly.springcloud.dao.DeptDao;
import com.fly.springcloud.entity.Dept;
import com.fly.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fly
 * @date 2018/8/5 20:00
 * @description: 部门服务实现类
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;
    /**
     * 添加部门
     *
     * @param dept
     * @return
     */
    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    /**
     * 根据部门id查询部门
     *
     * @param id
     * @return
     */
    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    /**
     * 查询所有部门
     *
     * @return
     */
    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }

    @Override
    public boolean update(Dept dept) {
        return deptDao.updateDept(dept);
    }
}

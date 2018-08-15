package com.fly.springcloud.service;

import com.fly.springcloud.entity.Dept;

import java.util.List;

/**
 * @author fly
 * @date 2018/8/5 19:57
 * @description
 **/
public interface DeptService {
    /**
     * 添加部门
     * @param dept
     * @return
     */
    boolean add(Dept dept);

    /**
     * 根据部门id查询部门
     * @param id
     * @return
     */
    Dept get(Long id);

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> list();

    /**
     * 更新
     * @param dept
     * @return
     */
    boolean update(Dept dept);
}

package com.fly.springcloud.dao;

import com.fly.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fly
 * @date 2018/8/5 19:27
 * @description: 部门的dao
 **/
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();

    boolean updateDept(Dept dept);
}

package com.fly.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author fly
 * @date 2018/7/25 23:04
 * @description
 **/
//全参构造函数
@AllArgsConstructor
@NoArgsConstructor
//设置set,get方法
@Data
@Accessors(chain = true)//链式方式访问
public class Dept implements Serializable {

    private static final long serialVersionUID = 2899540393566889066L;
    /**
     * 主键
     */
    private Long deptno;

    /**
     * 部门名称
     */
    private String dname;

    /**
     * 数据库来源
     */
    private String db_source;

}

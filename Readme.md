#测试数据库 (数据库类型为mysql)
CREATE TABLE `dept` (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
#初始化数据
insert into dept(dname, db_source) values('开发部', DATABASE());
insert into dept(dname, db_source) values('人事部', DATABASE());
insert into dept(dname, db_source) values('市场部', DATABASE());
insert into dept(dname, db_source) values('总体部', DATABASE());
insert into dept(dname, db_source) values('测试部', DATABASE());

这是一个微服务的案例
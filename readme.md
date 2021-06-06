## GMO系统介绍

GMO是一款基于SpringBoot、Mybatis Plus、Security和Knife4j等组件打造的一款基于后台服务RBAC管理信息系统。

- JDK: 11（JDK 8中的JJWT会出现异常）
- SpringBoot 2.4.5
- PostgreSQL 数据库
- Druid 作为数据源
- Mybatis Plus 作为半自动ORM系统
- Knife4j 作为API文档
- Security 作为权限系统
- Redis 使用redis作为token存储

[参考](https://www.cnblogs.com/cao-lei/)

### 0、系统启动的前置条件

1、安装java 11
2、安装PostgreSQL数据
3、安装Redis数据库
4、安装RabbitMQ消息序列

### 1、数据结构

由于我们使用的是Mybatis Plus作为ORM框架库，因此，在进行系统开发和部署之前，必须使用`sql`将对应的SQL语句进行执行，将必要的数据输入到数据库中。

本系统的sql文件保存在`resources\sql`中。

数据结构中包含了多张表：
- t_sys_menu: 菜单（权限）表
- t_sys_role: 角色表
- t_sys_role_menu: 角色菜单（权限）关联表
- t_sys_user: 用户表
- t_sys_user_role: 用户角色关联表

以上均为系统表，负责"用户-角色-权限"关系的建立。

- t_customer: 客户表

执行`user.sql`中的SQL命令，在数据库中新建表。

### 2、使用`MyBatisX Generator`建构系统的ORM组件

在数据库表中右键，打开`MybatisX Generator`，打开Mybatis生成器，生成对应的*Mapper.xml文件及*Mapper类、Entity类、Service类等。

注意：

```
basePackage: cn.geoportal.gmo.server
relativePackage: entity
```

#### 2.1 在`*mapper.xml`中添加合适方法的SQL语句

生成自定义的方法有两种方式：

- 在`mapper.xml`中撰写sql，然后在`Mapper`类中实现
- 在Mapper类中使用`@Select`方法实现

#### 2.2 在`test`中初始化用户系统

执行`PmsUserAdminTests.java`中的方法。

### 3.各组件访问

- druid http://127.0.0.1:3000/druid/
- api   http://127.0.0.1:3000/doc.html

### 4.Vue的设置

使用`vue ui`打开VUE系统，修正pms-ui的编译输出目录到resources/static即可。

### 5、测试代码

https://gitee.com/DeyN/yeb

https://www.bilibili.com/video/BV1U44y1r7iR?p=18&spm_id_from=pageDriver

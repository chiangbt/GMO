# GMO相关技术点

## 1、微服务项目的创建

1、从Intellij中新建一个SpringBoot项目。将其余文件都删除，仅留下pom文件。

2、新建module项目，类型选择maven-archetype-quickstart。

3、将模块项目的<parent/>设置为根目录的pom

## 2、初始化数据

1、执行sql文件，初始化数据库；

2、使用Mybatis plus进行ORM操作。注意修改application.yml中的`type-aliases-package`

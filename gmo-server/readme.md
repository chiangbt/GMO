## GMO-Server开发说明

GMO-Server是整个系统的后台核心部分，它由SpringBoot开发而成，包含了众多的组件和模块，实现了RBAC机制。

### 1、系统配置

本系统位于resources/application.yml文件。
系统运行端口为 3000

### 2、配置类

- common/KaptchaConfig： 验证码配置类，用于输出验证码的支付、颜色、字体和类型等设置；
- common/MultipartAutoConfig: 文件上传功能的配置类；
- common/MyFastJsonConfig：阿里巴巴fastjson的配置类，是系统中Object转JSON时的配置；
- common/MyMetaObjectHandler: Entity中类的createdat和updatedat两个字段的自动配置；

- mybatis/MybatisPlusConfig：Mybatis中翻页的配置类；

- security/JwtTokenUtil：Security中JWT的工具类
- security/SecurityConfig：安全配置类
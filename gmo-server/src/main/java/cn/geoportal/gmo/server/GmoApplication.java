package cn.geoportal.gmo.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server
 * @ClassName: GmoApplication
 * @Author: chiangbt@geoportal.cn
 * @Description: GMO-Server启动类
 * @Date: 2021/5/31 9:02
 */
@SpringBootApplication                          // SpringBoot应用程序
@MapperScan("cn.geoportal.gmo.server.mapper")   // 扫描mapper包
public class GmoApplication {

    /**
     * 1、启动前必须安装postgresql、redis、rabbitmq等软件
     * 2、多模块服务设置
     * @param args
     */
    public static void main(String[] args){
        SpringApplication.run(GmoApplication.class, args);
    }
}

package cn.geoportal.gmo.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server
 * @ClassName: GmoApplication
 * @Author: chiangbt@geoportal.cn
 * @Description: 启动类
 * @Date: 2021/5/31 9:02
 */
@SpringBootApplication
@MapperScan("cn.geoportal.gmo.server.mapper")
public class GmoApplication {

    public static void main(String[] args){
        SpringApplication.run(GmoApplication.class, args);
    }
}

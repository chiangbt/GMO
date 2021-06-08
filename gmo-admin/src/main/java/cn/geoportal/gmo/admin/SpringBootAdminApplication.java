package cn.geoportal.gmo.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.admin
 * @ClassName: SpringBootAdminApplication
 * @Author: chiangbt@geoportal.cn
 * @Description: SpringBootAdminApplication
 * @Date: 2021/6/8 9:43
 */
@EnableAdminServer
@SpringBootApplication
public class SpringBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminApplication.class, args);
    }
}

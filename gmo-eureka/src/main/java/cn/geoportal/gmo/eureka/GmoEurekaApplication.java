package cn.geoportal.gmo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class GmoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmoEurekaApplication.class, args);
    }

}

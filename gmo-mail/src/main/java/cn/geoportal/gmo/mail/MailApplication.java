package cn.geoportal.gmo.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: chiangbt@geoportal.cn
 * @CreatedAt: 2021/6/6 9:48 上午
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);
    }
}

package cn.geoportal.gmo.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.mail
 * @ClassName: MailApplication
 * @Author: chiangbt@geoportal.cn
 * @Description: MailApp
 * @Date: 2021/6/3 18:25
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MailApplication {

    public static void main(String[] args){
        SpringApplication.run(MailApplication.class, args);
    }
}

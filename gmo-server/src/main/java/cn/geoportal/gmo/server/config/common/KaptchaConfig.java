package cn.geoportal.gmo.server.config.common;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.config.common
 * @ClassName: KaptchaConfig
 * @Author: chiangbt@geoportal.cn
 * @Description: 验证码配置类
 * @Date: 2021/5/31 11:28
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha getDefaultKaptcha() {
        Properties properties = new Properties();
        // 图片边框
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "no");
        properties.setProperty("kaptcha.border.color", "220,227,232");
        // 边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        // 图片宽
        properties.setProperty("kaptcha.image.width", "110");
        // 图片高
        properties.setProperty("kaptcha.image.height", "30");
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "26");
        // session key
        properties.setProperty("kaptcha.session.key", "code");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", "Verdana");
        properties.setProperty("kaptcha.noise.color", "35,37,38");
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");

        Config config = new Config(properties);

        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}

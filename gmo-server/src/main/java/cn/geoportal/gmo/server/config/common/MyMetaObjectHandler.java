package cn.geoportal.gmo.server.config.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.config.common
 * @ClassName: MyMetaObjectHandler
 * @Author: chiangbt@geoportal.cn
 * @Description: 数据库日期字段配置
 * @Date: 2021/5/31 10:07
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //根据名称设置属性值
        this.setFieldValByName("createdat",new Date(),metaObject);
        this.setFieldValByName("updatedat",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedat",new Date(),metaObject);
    }
}

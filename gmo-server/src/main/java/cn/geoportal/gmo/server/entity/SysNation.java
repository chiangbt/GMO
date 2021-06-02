package cn.geoportal.gmo.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 民族表
 * @TableName t_sys_nation
 */
@TableName(value ="t_sys_nation")
@Data
public class SysNation implements Serializable {
    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 民族
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
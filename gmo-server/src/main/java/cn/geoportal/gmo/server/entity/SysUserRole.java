package cn.geoportal.gmo.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_sys_user_role
 */
@TableName(value ="t_sys_user_role")
@Data
public class SysUserRole implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
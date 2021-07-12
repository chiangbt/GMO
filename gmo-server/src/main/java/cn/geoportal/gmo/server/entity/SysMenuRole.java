package cn.geoportal.gmo.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 菜单权限表
 * @TableName t_sys_menu_role
 */
@TableName(value ="t_sys_menu_role")
@Data
public class SysMenuRole implements Serializable {
    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 菜单id
     */
    private Long menuId;

    /**
     * 权限id
     */
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
package cn.geoportal.gmo.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 菜单表
 * @TableName t_sys_menu
 */
@TableName(value ="t_sys_menu")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Menu对象", description = "")
public class SysMenu implements Serializable {
    /**
     * ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * url
     */
    @JSONField(ordinal = 1)
    @ApiModelProperty(value = "url")
    private String url;

    /**
     * path
     */
    @JSONField(ordinal = 2)
    @ApiModelProperty(value = "path")
    private String path;

    /**
     * 组件
     */
    @JSONField(ordinal = 3)
    @ApiModelProperty(value = "组件")
    private String component;

    /**
     * 菜单名
     */
    @JSONField(ordinal = 4)
    @ApiModelProperty(value = "菜单名")
    private String name;

    /**
     * 菜单图标
     */
    @JSONField(ordinal = 5)
    @ApiModelProperty(value = "菜单图标")
    private String iconcls;

    /**
     * 是否保持激活
     */
    @JSONField(ordinal = 6)
    @ApiModelProperty(value = "是否保持激活")
    private Long keepalive;

    /**
     * 是否要求权限
     */
    @JSONField(ordinal = 7)
    @ApiModelProperty(value = "是否要求权限")
    private Long requireauth;

    /**
     * 父id
     */
    @JSONField(ordinal = 8)
    @ApiModelProperty(value = "父id")
    private Long parentid;

    /**
     * 是否启用
     */
    @JSONField(ordinal = 9)
    @ApiModelProperty(value = "是否启用")
    private Long enabled;

    /**
     * 数据库中不存在这个字段
     */
    @JSONField(ordinal = 10)
    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<SysMenu> children;


    /**
     * 数据库中不存在这个字段
     */
    @JSONField(ordinal = 11)
    @ApiModelProperty(value = "角色列表")
    @TableField(exist = false)
    private List<SysRole> roles;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysMenu other = (SysMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
            && (this.getComponent() == null ? other.getComponent() == null : this.getComponent().equals(other.getComponent()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIconcls() == null ? other.getIconcls() == null : this.getIconcls().equals(other.getIconcls()))
            && (this.getKeepalive() == null ? other.getKeepalive() == null : this.getKeepalive().equals(other.getKeepalive()))
            && (this.getRequireauth() == null ? other.getRequireauth() == null : this.getRequireauth().equals(other.getRequireauth()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getComponent() == null) ? 0 : getComponent().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIconcls() == null) ? 0 : getIconcls().hashCode());
        result = prime * result + ((getKeepalive() == null) ? 0 : getKeepalive().hashCode());
        result = prime * result + ((getRequireauth() == null) ? 0 : getRequireauth().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", url=").append(url);
        sb.append(", path=").append(path);
        sb.append(", component=").append(component);
        sb.append(", name=").append(name);
        sb.append(", iconcls=").append(iconcls);
        sb.append(", keepalive=").append(keepalive);
        sb.append(", requireauth=").append(requireauth);
        sb.append(", parentid=").append(parentid);
        sb.append(", enabled=").append(enabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
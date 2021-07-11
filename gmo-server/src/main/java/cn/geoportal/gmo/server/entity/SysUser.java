package cn.geoportal.gmo.server.entity;

import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * SysUser实现UserDetails接口
 * 可以实现基于自定义的DB架构的认证与授权
 * @TableName t_sys_user
 */
@ApiModel(value = "系统用户")
@TableName(value ="t_sys_user")
@Data
public class SysUser implements Serializable, UserDetails {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 0)
    @ApiModelProperty(value = "id", required = false, hidden = true)
    private Long id;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名")
    @JSONField(ordinal = 1)
    private String username;

    /**
     * 电子邮件
     */
    @ApiModelProperty(value = "电子邮件")
    @JSONField(ordinal = 2)
    private String email;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    @JSONField(ordinal = 3)
    private String password;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    @JSONField(ordinal = 4)
    private String name;

    /**
     * 民族
     */
    @ApiModelProperty(value = "民族")
    @JSONField(ordinal = 5)
    private Integer nationid;

    /**
     *
     */
    @JSONField(ordinal = 6)
    @ApiModelProperty(value = "民族")
    @TableField(exist = false)
    @ExcelEntity(name = "民族")
    private SysNation nation;

    /**
     * 政治面貌
     */
    @ApiModelProperty(value = "政治面貌")
    @JSONField(ordinal = 7)
    private Integer politicid;

    /**
     *
     */
    @JSONField(ordinal = 8)
    @ApiModelProperty(value = "政治面貌")
    @TableField(exist = false)
    private SysPoliticsStatus politicsStatus;

    /**
     * 移动电话
     */
    @ApiModelProperty(value = "移动电话")
    @JSONField(ordinal = 9)
    private String phone;

    /**
     * 用户地址
     */
    @ApiModelProperty(value = "地址")
    @JSONField(ordinal = 10)
    private String address;

    /**
     * 是否激活
     */
    @ApiModelProperty(value = "是否激活")
    @JSONField(ordinal = 11)
    @Getter(AccessLevel.NONE)
    private Boolean enabled;

    /**
     * 用户图标
     */
    @ApiModelProperty(value = "用户图像")
    @JSONField(ordinal = 12)
    private String userface;

    /**
     * 用户注记
     */
    @ApiModelProperty(value = "注记")
    @JSONField(ordinal = 13)
    private String remark;

    /**
     * 用户角色
     * 非数据表的字段
     */
    @JSONField(ordinal = 14)
    @ApiModelProperty(value = "角色")
    @TableField(exist = false)
    private List<SysRole> roles;

    /**
     * 新建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "新建时间")
    @JSONField(ordinal = 15)
    private Date createdat;

    /**
     * 更新时间
     */
    @TableField(value = "updatedat", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    @JSONField(ordinal = 16)
    private Date updatedat;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @JSONField(ordinal = 17)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return authorities;
    }

    @JSONField(ordinal = 18)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JSONField(ordinal = 19)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JSONField(ordinal = 20)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
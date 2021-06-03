package cn.geoportal.gmo.server.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 工资表
 * @TableName t_sys_employee
 */
@TableName(value ="t_sys_employee")
@Data
public class SysEmployee implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 1)
    private Long id;

    /**
     * 名称
     */
    @JSONField(ordinal = 2)
    @Excel(name = "姓名")     // 
    private String name;

    /**
     * 性别
     */
    @JSONField(ordinal = 3)
    @Excel(name = "性别")
    private String gender;

    /**
     * 生日
     */
    @JSONField(ordinal = 4)
    @Excel(name = "出生日期", width = 20, format = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 身份证
     */
    @JSONField(ordinal = 5)
    @Excel(name = "身份证号码", width = 38)
    private String idcard;

    /**
     * 婚姻状况
     */
    @JSONField(ordinal = 6)
    private String wedlock;

    /**
     * 民族
     */
    @JSONField(ordinal = 7)
    @ApiModelProperty(value = "nationid", required = false, hidden = true)
    private Integer nationid;

    /**
     * 籍贯
     */
    @JSONField(ordinal = 8)
    private String nativeplace;

    /**
     * 政治面貌
     */
    @JSONField(ordinal = 9)
    private Integer politicid;

    /**
     * 邮箱
     */
    @JSONField(ordinal = 10)
    private String email;

    /**
     * 电话
     */
    @JSONField(ordinal = 11)
    private String phone;

    /**
     * 地址
     */
    @JSONField(ordinal = 12)
    private String address;

    /**
     * 所属部门
     */
    @JSONField(ordinal = 13)
    private Integer departmentid;

    /**
     * 职称ID
     */
    @JSONField(ordinal = 14)
    private Integer joblevelid;

    /**
     * 职位ID
     */
    @JSONField(ordinal = 15)
    @ApiModelProperty(value = "posid", required = false, hidden = true)
    private Integer posid;

    /**
     * 聘用形式
     */
    @JSONField(ordinal = 16)
    private String engageform;

    /**
     * 最高学历
     */
    @JSONField(ordinal = 17)
    private String tiptopdegree;

    /**
     * 所属专业
     */
    @JSONField(ordinal = 18)
    private String specialty;

    /**
     * 毕业院校
     */
    @JSONField(ordinal = 19)
    private String school;

    /**
     * 入职日期
     */
    @JSONField(ordinal = 20)
    private Date begindate;

    /**
     * 在职状态
     */
    @JSONField(ordinal = 21)
    private String workstate;

    /**
     * 工号
     */
    @JSONField(ordinal = 22)
    private String workid;

    /**
     * 合同期限
     */
    @JSONField(ordinal = 23)
    private Double contractterm;

    /**
     * 转正日期
     */
    @JSONField(ordinal = 24)
    private Date conversiontime;

    /**
     * 离职日期
     */
    @JSONField(ordinal = 25)
    private Date notworkdate;

    /**
     * 合同起始日期
     */
    @JSONField(ordinal = 26)
    private Date begincontract;

    /**
     * 合同终止日期
     */
    @JSONField(ordinal = 27)
    private Date endcontract;

    /**
     * 工龄
     */
    @JSONField(ordinal = 28)
    private Integer workage;

    /**
     * 工资账套ID
     */
    @JSONField(ordinal = 29)
    private Integer salaryid;

    @JSONField(ordinal = 30)
    @ApiModelProperty(value = "民族")
    @TableField(exist = false)
    @ExcelEntity(name = "民族")
    private SysNation nation;

    @JSONField(ordinal = 31)
    @ApiModelProperty(value = "政治面貌")
    @TableField(exist = false)
    private SysPoliticsStatus politicsStatus;

    @JSONField(ordinal = 32)
    @ApiModelProperty(value = "部门")
    @TableField(exist = false)
    private SysDepartment department;

    @JSONField(ordinal = 33)
    @ApiModelProperty(value = "职称")
    @TableField(exist = false)
    private SysJoblevel joblevel;

    @JSONField(ordinal = 34)
    @ApiModelProperty(value = "职位")
    @TableField(exist = false)
    private SysPosition position;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
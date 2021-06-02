package cn.geoportal.gmo.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
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
    @TableId
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 基本工资
     */
    private String gender;

    /**
     * 奖金
     */
    private Date birthday;

    /**
     * 午餐补助
     */
    private String idcard;

    /**
     * 婚姻状况
     */
    private Object wedlock;

    /**
     * 民族
     */
    private Integer nationid;

    /**
     * 籍贯
     */
    private String nativeplace;

    /**
     * 政治面貌
     */
    private Integer politicid;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 所属部门
     */
    private Integer departmentid;

    /**
     * 职称ID
     */
    private Integer joblevelid;

    /**
     * 职位ID
     */
    private Integer posid;

    /**
     * 聘用形式
     */
    private String engageform;

    /**
     * 最高学历
     */
    private Object tiptopdegree;

    /**
     * 所属专业
     */
    private String specialty;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 入职日期
     */
    private Date begindate;

    /**
     * 在职状态
     */
    private Object workstate;

    /**
     * 工号
     */
    private String workid;

    /**
     * 合同期限
     */
    private Double contractterm;

    /**
     * 转正日期
     */
    private Date conversiontime;

    /**
     * 离职日期
     */
    private Date notworkdate;

    /**
     * 合同起始日期
     */
    private Date begincontract;

    /**
     * 合同终止日期
     */
    private Date endcontract;

    /**
     * 工龄
     */
    private Integer workage;

    /**
     * 工资账套ID
     */
    private Integer salaryid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
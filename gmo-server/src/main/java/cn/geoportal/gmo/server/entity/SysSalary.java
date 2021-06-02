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
 * @TableName t_sys_salary
 */
@TableName(value ="t_sys_salary")
@Data
public class SysSalary implements Serializable {
    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 基本工资
     */
    private Double basicsalary;

    /**
     * 奖金
     */
    private Double bonus;

    /**
     * 午餐补助
     */
    private Double lunchsalary;

    /**
     * 交通补助
     */
    private Double trafficsalary;

    /**
     * 应发工资
     */
    private Double allsalary;

    /**
     * 养老金基数
     */
    private Double pensionbase;

    /**
     * 养老金比率
     */
    private Double pensionper;

    /**
     * 启用时间
     */
    private Date createdate;

    /**
     * 医疗基数
     */
    private Double medicalbase;

    /**
     * 医疗保险比率
     */
    private Double medicalper;

    /**
     * 公积金基数
     */
    private Double accumulationfundbase;

    /**
     * 公积金比率
     */
    private Double accumulationfundper;

    /**
     * 名称
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
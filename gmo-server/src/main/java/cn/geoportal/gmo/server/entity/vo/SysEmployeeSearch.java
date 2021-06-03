package cn.geoportal.gmo.server.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 为了保障SysEmployeeSearch的参数正确传输，确保其字段必须均为String
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.vo
 * @ClassName: SysEmployeeSearch
 * @Author: chiangbt@geoportal.cn
 * @Description: 雇员查询类
 * @Date: 2021/6/3 12:36
 */
@Data
public class SysEmployeeSearch {

    @ApiModelProperty(value = "姓名")
    @JSONField(ordinal = 0)
    private String name;

    @ApiModelProperty(value = "政治面貌")
    @JSONField(ordinal = 1)
    private String politicalstatus;

    @ApiModelProperty(value = "部门")
    @JSONField(ordinal = 2)
    private String departement;

    @ApiModelProperty(value = "职称")
    @JSONField(ordinal = 3)
    private String joblevel;

    @ApiModelProperty(value = "职位")
    @JSONField(ordinal = 4)
    private String position;

    @ApiModelProperty(value = "合同形式")
    @JSONField(ordinal = 5)
    private String engageform;
}

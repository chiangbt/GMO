package cn.geoportal.gmo.mail.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.mail.entity
 * @ClassName: MailMessage
 * @Author: chiangbt@geoportal.cn
 * @Description: MailMessage
 * @Date: 2021/6/6 15:38
 */
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = MailMessage.class)
public class MailMessage implements Serializable {
    private String empName;
    private String empId;

    public MailMessage(){

    }

    public MailMessage(String empName, String empId){
        this.empName = empName;
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee [empName=" + empName + ", empId=" + empId + "]";
    }
}

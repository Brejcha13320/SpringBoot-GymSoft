package co.edu.usbcali.gymsoft.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String employeeType;
    private String address;
    private String email;
    private String phone;
    private Boolean enabled;
    private Date createdAt;
    private Date updatedAt;

    //Employee Depende de un User
    private Integer userId;
}

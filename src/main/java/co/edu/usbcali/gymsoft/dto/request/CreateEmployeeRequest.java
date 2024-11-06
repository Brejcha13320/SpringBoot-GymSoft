package co.edu.usbcali.gymsoft.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String employeeType;
    private String address;
    private String email;
    private String phone;
    private Integer userId;
}

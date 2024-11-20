package co.edu.usbcali.gymsoft.dto.request;

import co.edu.usbcali.gymsoft.utils.validation.EmployeeMessage;
import co.edu.usbcali.gymsoft.utils.validation.MembershipMessage;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdateEmployeeRequest {

    @NotNull(message = EmployeeMessage.NOT_NULL_FIRST_NAME)
    @NotEmpty(message = EmployeeMessage.NOT_EMPTY_FIRST_NAME)
    @Size(max = 20, min = 4, message = EmployeeMessage.SIZE_FIRST_NAME)
    private String firstName;

    @NotNull(message = EmployeeMessage.NOT_NULL_LAST_NAME)
    @NotEmpty(message = EmployeeMessage.NOT_EMPTY_LAST_NAME)
    @Size(max = 20, min = 4, message = EmployeeMessage.SIZE_LAST_NAME)
    private String lastName;

    @NotNull(message = EmployeeMessage.NOT_NULL_EMPLOYEE_TYPE)
    @NotEmpty(message = EmployeeMessage.NOT_EMPTY_EMPLOYEE_TYPE)
    private String employeeType;

    @NotNull(message = EmployeeMessage.NOT_NULL_ADDRESS)
    @NotEmpty(message = EmployeeMessage.NOT_EMPTY_ADDRESS)
    @Size(max = 20, min = 4, message = EmployeeMessage.SIZE_ADDRESS)
    private String address;

    @Email(message = EmployeeMessage.INVALID_EMAIL)
    @NotEmpty(message = EmployeeMessage.NOT_EMPTY_EMAIL)
    private String email;

    @Pattern(regexp = "\\d+", message = EmployeeMessage.INVALID_PHONE)
    @NotEmpty(message = EmployeeMessage.NOT_EMPTY_PHONE)
    @Size(max = 30, min = 5, message = EmployeeMessage.SIZE_PHONE)
    private String phone;

    @NotNull(message = MembershipMessage.NOT_NULL_ENABLED)
    private Boolean enabled;

    private Integer userId;

}

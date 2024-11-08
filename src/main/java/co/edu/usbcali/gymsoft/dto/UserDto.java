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
public class UserDto {
    private Integer userId;
    private String username;
    private String password;
    private String role;
    private Boolean enabled;
    private Date createdAt;
    private Date updatedAt;
}

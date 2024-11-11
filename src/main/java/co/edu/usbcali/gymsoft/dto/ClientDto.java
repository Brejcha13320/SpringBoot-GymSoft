package co.edu.usbcali.gymsoft.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Integer clientId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private Boolean enabled;
    private Date createdAt;
    private Date updatedAt;
}
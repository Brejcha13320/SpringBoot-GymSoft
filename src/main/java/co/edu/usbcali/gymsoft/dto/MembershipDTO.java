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
public class MembershipDTO {
    private Integer membershipId;
    private String type;
    private String description;
    private Float cost;
    private Boolean enabled;
    private Date createdAt;
    private Date updatedAt;
}

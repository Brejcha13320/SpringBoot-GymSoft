package co.edu.usbcali.gymsoft.dto;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.domain.Membership;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientMembershipDTO {
    private Integer clientMembershipId;
    private Date startDate;
    private Date endDate;
    private Integer remainingDays;
    private Integer quantity;
    private Float cost;
    private Float price;
    private Boolean enabled;
    private Date createdAt;
    private Date updatedAt;
    private Integer clientId;
    private Integer membershipId;
}

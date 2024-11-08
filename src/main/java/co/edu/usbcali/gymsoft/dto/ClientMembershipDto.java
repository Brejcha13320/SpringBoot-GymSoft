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
public class ClientMembershipDto {
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
    private ClientDto client;
    private MembershipDto membership;
}

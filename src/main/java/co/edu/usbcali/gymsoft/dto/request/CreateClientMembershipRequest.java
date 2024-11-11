package co.edu.usbcali.gymsoft.dto.request;

import co.edu.usbcali.gymsoft.utils.validation.ClientMembershipMessage;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientMembershipRequest {

    @NotNull(message = ClientMembershipMessage.NOT_NULL_CLIENT_ID)
    private Integer clientId;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_MEMBERSHIP_ID)
    private Integer membershipId;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_START_DATE)
    private Date startDate;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_END_DATE)
    private Date endDate;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_REMAINING_DAYS)
    @Min(value = 0, message = ClientMembershipMessage.INVALID_REMAINING_DAYS)
    private Integer remainingDays;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_QUANTITY)
    @Min(value = 0, message = ClientMembershipMessage.INVALID_QUANTITY)
    private Integer quantity;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_COST)
    @DecimalMin(value = "0.0", message = ClientMembershipMessage.INVALID_COST)
    private Float cost;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_PRICE)
    @DecimalMin(value = "0.0", message = ClientMembershipMessage.INVALID_PRICE)
    private Float price;

}

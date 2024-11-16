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
public class UpdateClientMembershipRequest {

    @NotNull(message = ClientMembershipMessage.NOT_NULL_START_DATE)
    private Date startDate;

    private Date endDate;

    @Min(value = 1, message = ClientMembershipMessage.INVALID_REMAINING_DAYS)
    private Integer remainingDays;

    @Min(value = 1, message = ClientMembershipMessage.INVALID_QUANTITY)
    private Integer quantity;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_COST)
    @DecimalMin(value = "0.0", message = ClientMembershipMessage.INVALID_COST)
    private Float cost;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_PRICE)
    @DecimalMin(value = "0.0", message = ClientMembershipMessage.INVALID_PRICE)
    private Float price;

    @NotNull(message = ClientMembershipMessage.NOT_NULL_ENABLED)
    private Boolean enabled;

}

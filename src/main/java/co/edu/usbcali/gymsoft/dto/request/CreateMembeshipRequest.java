package co.edu.usbcali.gymsoft.dto.request;

import co.edu.usbcali.gymsoft.utils.validation.MembershipMessage;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMembeshipRequest {
    @NotNull(message = MembershipMessage.NOT_NULL_TYPE)
    @NotEmpty(message = MembershipMessage.NOT_EMPTY_TYPE)
    private String type;

    @NotNull(message = MembershipMessage.NOT_NULL_DESCRIPTION)
    @NotEmpty(message = MembershipMessage.NOT_EMPTY_DESCRIPTION)
    @Size(max = 20, min = 5, message = MembershipMessage.SIZE_DESCRIPTION)
    private String description;

    @NotNull(message = MembershipMessage.NOT_NULL_COST)
    @DecimalMin(value = "0.0", message = MembershipMessage.INVALID_COST)
    private Float cost;
}

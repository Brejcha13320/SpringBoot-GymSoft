package co.edu.usbcali.gymsoft.dto.request;

import co.edu.usbcali.gymsoft.utils.validation.MembershipMessage;
import co.edu.usbcali.gymsoft.utils.validation.UserMessage;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotNull(message = UserMessage.NOT_NULL_USERNAME)
    @NotEmpty(message = UserMessage.NOT_EMPTY_USERNAME)
    @Size(max = 10, min = 3, message = UserMessage.SIZE_USERNAME)
    private String username;

    @NotNull(message = UserMessage.NOT_NULL_PASSWORD)
    @NotEmpty(message = UserMessage.NOT_EMPTY_PASSWORD)
    @Size(max = 15, min = 3, message = UserMessage.SIZE_PASSWORD)
    private String password;

    @NotNull(message = UserMessage.NOT_NULL_ROLE)
    @NotEmpty(message = UserMessage.NOT_EMPTY_ROLE)
    private String role;

    @NotNull(message = MembershipMessage.NOT_NULL_ENABLED)
    private Boolean enabled;

}

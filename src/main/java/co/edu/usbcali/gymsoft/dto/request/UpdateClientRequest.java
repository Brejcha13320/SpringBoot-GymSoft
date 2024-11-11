package co.edu.usbcali.gymsoft.dto.request;

import co.edu.usbcali.gymsoft.utils.validation.ClientMessage;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientRequest {

    @NotNull(message = ClientMessage.NOT_NULL_FIRST_NAME)
    @NotEmpty(message = ClientMessage.NOT_EMPTY_FIRST_NAME)
    @Size(max = 20, min = 5, message = ClientMessage.SIZE_FIRST_NAME)
    private String firstName;

    @NotNull(message = ClientMessage.NOT_NULL_LAST_NAME)
    @NotEmpty(message = ClientMessage.NOT_EMPTY_LAST_NAME)
    @Size(max = 20, min = 5, message = ClientMessage.SIZE_LAST_NAME)
    private String lastName;

    @NotNull(message = ClientMessage.NOT_NULL_ADDRESS)
    @NotEmpty(message = ClientMessage.NOT_EMPTY_ADDRESS)
    @Size(max = 50, min = 5, message = ClientMessage.SIZE_ADDRESS)
    private String address;

    @NotNull(message = ClientMessage.NOT_NULL_EMAIL)
    @NotEmpty(message = ClientMessage.NOT_EMPTY_EMAIL)
    @Email(message = ClientMessage.INVALID_EMAIL)
    @Size(max = 255, message = ClientMessage.SIZE_EMAIL)
    private String email;

    @NotNull(message = ClientMessage.NOT_NULL_PHONE)
    @NotEmpty(message = ClientMessage.NOT_EMPTY_PHONE)
    @Size(max = 20, message = ClientMessage.SIZE_PHONE)
    @Pattern(regexp = "\\d+", message = ClientMessage.REGEX_PHONE)
    private String phone;

}

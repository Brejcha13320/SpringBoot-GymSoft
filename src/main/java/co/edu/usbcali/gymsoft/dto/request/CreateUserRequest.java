package co.edu.usbcali.gymsoft.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    @NotNull(message = "El username no puede ser nulo")
    @NotEmpty(message = "El username no puede estar vacio")
    @Size(max = 10, min = 3, message = "El username no puede tener menos de 3 caracteres y mas de 10 caracteres")
    private String username;

    @NotNull(message = "El password no puede ser nulo")
    @NotEmpty(message = "El password no puede estar vacio")
    private String password;

    @NotNull(message = "El role no puede ser nulo")
    @NotEmpty(message = "El role no puede estar vacio")
    private String role;
}

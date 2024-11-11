package co.edu.usbcali.gymsoft.utils.validation;

public class UserMessage {

    public static final String NOT_NULL_USERNAME="El username no puede ser nulo";
    public static final String NOT_EMPTY_USERNAME="El username no puede estar vacio";
    public static final String SIZE_USERNAME="El username no puede tener menos de 3 caracteres y mas de 10 caracteres";

    public static final String NOT_NULL_PASSWORD="El password no puede ser nulo";
    public static final String NOT_EMPTY_PASSWORD="El password no puede estar vacio";
    public static final String SIZE_PASSWORD="El password no puede tener menos de 3 caracteres y mas de 15 caracteres";

    public static final String NOT_NULL_ROLE="El role no puede ser nulo";
    public static final String NOT_EMPTY_ROLE="El role no puede estar vacio";

    public static final String EXISTS_BY_USERNAME = "Ya existe un usuario con el username: %s";
}

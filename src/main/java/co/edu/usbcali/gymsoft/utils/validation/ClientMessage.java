package co.edu.usbcali.gymsoft.utils.validation;

public class ClientMessage {

    public static final String NOT_NULL_FIRST_NAME="El firstName no puede ser nulo";
    public static final String NOT_EMPTY_FIRST_NAME="El firstName no puede estar vacio";
    public static final String SIZE_FIRST_NAME ="El firstName no puede tener menos de 5 caracteres y mas de 20 caracteres";

    public static final String NOT_NULL_LAST_NAME="El lastName no puede ser nulo";
    public static final String NOT_EMPTY_LAST_NAME="El lastName no puede estar vacio";
    public static final String SIZE_LAST_NAME ="El lastName no puede tener menos de 5 caracteres y mas de 20 caracteres";

    public static final String NOT_NULL_ADDRESS="El address no puede ser nulo";
    public static final String NOT_EMPTY_ADDRESS="El address no puede estar vacio";
    public static final String SIZE_ADDRESS ="El address no puede tener menos de 5 caracteres y mas de 50 caracteres";

    public static final String NOT_NULL_EMAIL="El email no puede ser nulo";
    public static final String NOT_EMPTY_EMAIL="El email no puede estar vacio";
    public static final String SIZE_EMAIL ="El email no puede tener mas de 255 caracteres";
    public static final String INVALID_EMAIL ="El email no tiene un formato valido";


    public static final String NOT_NULL_PHONE="El phone no puede ser nulo";
    public static final String NOT_EMPTY_PHONE="El phone no puede estar vacio";
    public static final String SIZE_PHONE="El phone no puede tener mas de 20 digitos";
    public static final String REGEX_PHONE="El phone solo puede tener digitos";

    public static final String EXISTS_BY_EMAIL = "Ya existe un client con el email: %s";

}

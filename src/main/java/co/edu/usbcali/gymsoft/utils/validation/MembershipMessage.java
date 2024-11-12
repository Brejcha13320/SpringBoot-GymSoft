package co.edu.usbcali.gymsoft.utils.validation;

public class MembershipMessage {

    public static final String NOT_NULL_TYPE="El campo type no puede ser nulo";
    public static final String NOT_EMPTY_TYPE="El campo type no puede estar vacio";

    public static final String NOT_NULL_DESCRIPTION="El campo description no puede ser nulo";
    public static final String NOT_EMPTY_DESCRIPTION="El campo description no puede estar vacio";
    public static final String SIZE_DESCRIPTION ="El campo description no puede tener mas de 255 caracteres";

    public static final String NOT_NULL_COST="El campo cost no puede ser nulo";
    public static final String INVALID_COST="El campo cost no puede ser inferior a 0.0";

    public static final String SIZE_TYPE = "El campo size no puede tener menos de 1 caracteres y mas de 50 caracteres";
    public static final String NOT_NULL_ENABLED = "El campo enabled no puede ser nulo";

}

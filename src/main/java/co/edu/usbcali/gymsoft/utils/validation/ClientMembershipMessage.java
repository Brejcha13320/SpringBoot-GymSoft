package co.edu.usbcali.gymsoft.utils.validation;

public class ClientMembershipMessage {

    public static final String NOT_NULL_CLIENT_ID="El campo clientId no puede ser nulo";

    public static final String NOT_NULL_MEMBERSHIP_ID="El campo membershipId no puede ser nulo";

    public static final String NOT_NULL_START_DATE="El campo startDate no puede ser nulo";

    public static final String NOT_NULL_END_DATE="El campo endDate no puede ser nulo";

    public static final String NOT_NULL_REMAINING_DAYS="El campo remainingDays no puede ser nulo";
    public static final String INVALID_REMAINING_DAYS="El campo remainingDays no puede ser menor que 1";

    public static final String NOT_NULL_QUANTITY="El campo quantity no puede ser nulo";
    public static final String INVALID_QUANTITY="El campo quantity no puede ser menor que 1";

    public static final String NOT_NULL_COST="El campo cost no puede ser nulo";
    public static final String INVALID_COST="El campo cost no puede ser inferior a 0.0";

    public static final String NOT_NULL_PRICE="El campo price no puede ser nulo";
    public static final String INVALID_PRICE="El campo price no puede ser inferior a 0.0";

    public static final String EXISTS_CLIENT = "No existe un client con el id: %s";
    public static final String EXISTS_MEMBERSHIP = "No existe un membership con el id: %s";

    public static final String NOT_NULL_ENABLED = "El campo enabled no puede ser nulo";

}

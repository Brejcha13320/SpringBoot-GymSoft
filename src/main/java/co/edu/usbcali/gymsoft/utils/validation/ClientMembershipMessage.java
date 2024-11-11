package co.edu.usbcali.gymsoft.utils.validation;

public class ClientMembershipMessage {

    public static final String NOT_NULL_CLIENT_ID="El clientId no puede ser nulo";

    public static final String NOT_NULL_MEMBERSHIP_ID="El membershipId no puede ser nulo";

    public static final String NOT_NULL_START_DATE="El startDate no puede ser nulo";

    public static final String NOT_NULL_END_DATE="El endDate no puede ser nulo";

    public static final String NOT_NULL_REMAINING_DAYS="El remainingDays no puede ser nulo";
    public static final String INVALID_REMAINING_DAYS="El remainingDays debe ser minimo 0";

    public static final String NOT_NULL_QUANTITY="El quantity no puede ser nulo";
    public static final String INVALID_QUANTITY="El quantity debe ser minimo 0";

    public static final String NOT_NULL_COST="El cost no puede ser nulo";
    public static final String INVALID_COST="El cost debe ser un numero valido";

    public static final String NOT_NULL_PRICE="El price no puede ser nulo";
    public static final String INVALID_PRICE="El price debe ser un numero valido";

    public static final String EXISTS_CLIENT = "No existe un client con el id: %s";
    public static final String EXISTS_MEMBERSHIP = "No existe un membership con el id: %s";

}

package co.edu.usbcali.gymsoft.utils.validation;

public class EmployeeMessage {

    // Nombre
    public static final String NOT_NULL_FIRST_NAME = "El nombre no puede ser nulo";
    public static final String NOT_EMPTY_FIRST_NAME = "El nombre no puede estar vacío";
    public static final String SIZE_FIRST_NAME = "El nombre debe tener entre 4 y 20 caracteres";

    // Apellido
    public static final String NOT_NULL_LAST_NAME = "El apellido no puede ser nulo";
    public static final String NOT_EMPTY_LAST_NAME = "El apellido no puede estar vacío";
    public static final String SIZE_LAST_NAME = "El apellido debe tener entre 4 y 20 caracteres";

    // Tipo empleado
    public static final String NOT_NULL_EMPLOYEE_TYPE = "El tipo de empleado no puede ser nulo";
    public static final String NOT_EMPTY_EMPLOYEE_TYPE = "El tipo de empleado no puede estar vacío";
    public static final String NOT_EXISTS_BY_EMPLOYEE_ID = "El empleado no existe";
    // Dirección
    public static final String NOT_NULL_ADDRESS = "La dirección no puede ser nula";
    public static final String NOT_EMPTY_ADDRESS = "La dirección no puede estar vacía";
    public static final String SIZE_ADDRESS = "La dirección debe tener entre 5 y 50 caracteres";

    // Email
    public static final String INVALID_EMAIL = "Correo electrónico inválido";
    public static final String EXISTS_BY_EMAIL = "El correo ya existe: %s";
    public static final String NOT_EMPTY_EMAIL = "El correo electrónico no puede estar vacío";

    // Teléfono
    public static final String INVALID_PHONE = "Número de teléfono inválido";
    public static final String NOT_EMPTY_PHONE = "El número de teléfono no puede estar vacío";
    public static final String SIZE_PHONE = "eL telefono debe tener entre 5 y 50 caracteres";

}



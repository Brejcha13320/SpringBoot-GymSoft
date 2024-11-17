package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.Employee;
import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.EmployeeDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEmployeeRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateEmployeeRequest;
import co.edu.usbcali.gymsoft.mapper.EmployeeMapper;
import co.edu.usbcali.gymsoft.repository.EmployeeRepository;
import co.edu.usbcali.gymsoft.repository.UserRepository;
import co.edu.usbcali.gymsoft.service.EmployeeService;
import co.edu.usbcali.gymsoft.utils.validation.EmployeeMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() throws Exception{
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.domainToDtoList(employees);
    }

    @Override
    public EmployeeDTO findEmployeeById(Integer employeeId) throws Exception {
        // Busca el empleado por ID y lanza una excepción si no se encuentra
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception(String.format(EmployeeMessage.NOT_EXISTS_BY_EMPLOYEE_ID, employeeId)));

        // Convierte la entidad Employee a DTO y la devuelve
        return EmployeeMapper.domainToDto(employee);
    }


    @Override
    public EmployeeDTO createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception {
        // Valida que exista el usuario
        Integer userId = createEmployeeRequest.getUserId();

        // Convierte la solicitud a la entidad Employee
        Employee employee = EmployeeMapper.createEmployeeRequestToDomain(createEmployeeRequest);

        // Si userId no es nulo ni 0, verifica que el usuario existe y asigna el usuario al empleado
        if (userId != null && userId != 0) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new Exception(String.format(EmployeeMessage.EXISTS_USER, userId)));
            employee.setUser(user);
        }

        // Verifica si el email ya existe en la base de datos
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new Exception(String.format(EmployeeMessage.EXISTS_BY_EMAIL, employee.getEmail()));
        }

        // Guarda el empleado en la base de datos
        employee = employeeRepository.save(employee);

        // Convierte la entidad Employee a DTO y la devuelve
        EmployeeDTO employeeDTO = EmployeeMapper.domainToDto(employee);
        return employeeDTO;
    }


    @Override
    public EmployeeDTO updateEmployee(Integer employeeId, UpdateEmployeeRequest updateEmployeeRequest) throws Exception {
        // Encuentra el empleado por ID
        EmployeeDTO employeeDTO = findEmployeeById(employeeId);
        Employee employee = EmployeeMapper.dtoToDomain(employeeDTO);
        employee = EmployeeMapper.updateEmployeeRequestToDomain(employee, updateEmployeeRequest);

        // Valida que exista el usuario, si es necesario actualizar el usuario
        Integer userId = updateEmployeeRequest.getUserId();
        if (userId != null && userId != 0) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new Exception(String.format(EmployeeMessage.EXISTS_USER, userId)));
            employee.setUser(user);
        }

        // Verifica si el email ha cambiado y si el nuevo email ya existe en la base de datos
        String newEmail = employee.getEmail();
        if (!employeeDTO.getEmail().equals(newEmail) && employeeRepository.existsByEmail(newEmail)) {
            throw new Exception(String.format(EmployeeMessage.EXISTS_BY_EMAIL, newEmail));
        }

        // Guarda el empleado actualizado
        employee = employeeRepository.save(employee);

        return EmployeeMapper.domainToDto(employee);
    }

    @Override
    public void deleteEmployee(Integer employeeId) throws Exception {
        EmployeeDTO employeeDTO = findEmployeeById(employeeId);
        Employee employee = EmployeeMapper.dtoToDomain(employeeDTO);
        employeeRepository.delete(employee);
    }

}

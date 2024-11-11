package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.Employee;
import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.EmployeeDTO;
import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEmployeeRequest;
import co.edu.usbcali.gymsoft.mapper.EmployeeMapper;
import co.edu.usbcali.gymsoft.mapper.UserMapper;
import co.edu.usbcali.gymsoft.repository.EmployeeRepository;
import co.edu.usbcali.gymsoft.repository.UserRepository;
import co.edu.usbcali.gymsoft.service.EmployeeService;
import co.edu.usbcali.gymsoft.utils.validation.EmployeeMessage;
import co.edu.usbcali.gymsoft.utils.validation.UserMessage;
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
    public EmployeeDTO findEmployeeById(Integer employeeId) throws Exception{
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new Exception(String.format(EmployeeMessage.NOT_EXISTS_BY_EMPLOYEE_ID, employeeId))
        );

        return EmployeeMapper.domainToDto(employee);
    }

    @Override
    public EmployeeDTO createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception {

        //Valida que exista el usuario
        Integer userId = createEmployeeRequest.getUserId();

        Employee employee = EmployeeMapper.createEmployeeRequestToDomain(createEmployeeRequest);

        if (!(userId == null || userId == 0)) {
            User user = userRepository.findById(userId)
                    .orElseThrow(
                            () -> new Exception(String.format(EmployeeMessage.EXISTS_EMPLOYEE, userId))
                    );
            employee.setUser(user);
        }

        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new Exception(String.format(EmployeeMessage.EXISTS_BY_EMAIL, employee.getEmail()));
        }

        employee = employeeRepository.save(employee);
        EmployeeDTO employeeDTO = EmployeeMapper.domainToDto(employee);
        return employeeDTO;
    }

}

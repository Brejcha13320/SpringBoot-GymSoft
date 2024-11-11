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
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl {

//    private final EmployeeRepository employeeRepository;
//    private final UserRepository userRepository;
//
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository) {
//        this.employeeRepository = employeeRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public EmployeeDTO createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception {
//
//        if(createEmployeeRequest == null) {
//            throw new Exception("No ha llegado el objeto employee para crear");
//        }
//
//        //Validar firstName
//        if(createEmployeeRequest.getFirstName() == null || createEmployeeRequest.getFirstName().equals("")) {
//            throw new Exception("El firstName no puede ser nulo ni vacio");
//        }
//
//        //Validar que el usuario exista
//        if(!employeeRepository.existsById(createEmployeeRequest.getUserId())){
//            throw new Exception("El usuario no existe");
//        }
//
//        //User user = userRepository.getReferenceById(createEmployeeRequest.getUserId());
//
//        Employee employee = EmployeeMapper.createEmployeeRequestToDomain(createEmployeeRequest);
//        employee = employeeRepository.save(employee);
//        EmployeeDTO employeeDTO = EmployeeMapper.domainToDto(employee);
//        return employeeDTO;
//
//    }

}

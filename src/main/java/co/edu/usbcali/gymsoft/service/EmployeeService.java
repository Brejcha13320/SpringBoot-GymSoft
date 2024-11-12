package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.EmployeeDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEmployeeRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeDTO> findAllEmployees() throws Exception;
    public EmployeeDTO findEmployeeById(Integer employeeId) throws Exception;
    public EmployeeDTO createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception;
    public EmployeeDTO updateEmployee(Integer employeeId, UpdateEmployeeRequest updateEmployeeRequest) throws Exception;
    void deleteEmployee(Integer employeeId) throws Exception;
}

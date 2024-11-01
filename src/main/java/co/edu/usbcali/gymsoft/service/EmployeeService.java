package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.domain.Employee;
import co.edu.usbcali.gymsoft.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getById(int employeeId){
        return this.employeeRepository.getReferenceById(employeeId);
    }

    public List<Employee> getAll(){
        return this.employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return this.employeeRepository.save(employee);
    }

}

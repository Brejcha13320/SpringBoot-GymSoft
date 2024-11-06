package co.edu.usbcali.gymsoft.services.old;

import co.edu.usbcali.gymsoft.domain.Employee;
import co.edu.usbcali.gymsoft.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeServiceOld {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceOld(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getById(int employeeId){

        return this.employeeRepository.findById(employeeId).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    public List<Employee> getAll(){
        return this.employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return this.employeeRepository.save(employee);
    }

}

package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.Employee;
import co.edu.usbcali.gymsoft.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getById(@PathVariable int employeeId){
        return ResponseEntity.ok(employeeService.getById(employeeId));
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }


}

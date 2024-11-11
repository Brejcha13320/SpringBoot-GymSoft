package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.Employee;
//import co.edu.usbcali.gymsoft.services.old.EmployeeServiceOld;
import co.edu.usbcali.gymsoft.dto.EmployeeDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEmployeeRequest;
import co.edu.usbcali.gymsoft.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws Exception{
        List<EmployeeDTO> employeeDTO = employeeService.findAllEmployees();
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping(value = "/one/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer employeeId) throws Exception{
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid CreateEmployeeRequest createEmployeeRequest) throws Exception{
        EmployeeDTO employeeDTO = employeeService.createEmployee(createEmployeeRequest);
        return ResponseEntity.ok(employeeDTO);
    }

}

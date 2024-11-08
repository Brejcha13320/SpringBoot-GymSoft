package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.Employee;
import co.edu.usbcali.gymsoft.dto.EmployeeDto;

public class EmployeeMapper {

    public EmployeeDto toEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .employeeType(employee.getEmployeeType())
                .address(employee.getAddress())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .enabled(employee.getEnabled())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                //.user(employee.getUser())
                .build();
    }

    public Employee toEmployeeDto(EmployeeDto employeeDto) {
        return Employee.builder()
                .employeeId(employeeDto.getEmployeeId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .employeeType(employeeDto.getEmployeeType())
                .address(employeeDto.getAddress())
                .email(employeeDto.getEmail())
                .phone(employeeDto.getPhone())
                .enabled(employeeDto.getEnabled())
                .createdAt(employeeDto.getCreatedAt())
                .updatedAt(employeeDto.getUpdatedAt())
                //.user(employeeDto.getUser())
                .build();
    }

}

package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.Employee;
import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.EmployeeDto;
import co.edu.usbcali.gymsoft.dto.UserDto;

import java.util.List;

public class EmployeeMapper {

    public static EmployeeDto domainToDto(Employee employee) {
        return EmployeeDto.builder()
                .employeeId(employee.getEmployeeId())
                .userId(employee.getUser() == null ? null : employee.getUser().getUserId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .employeeType(employee.getEmployeeType())
                .address(employee.getAddress())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .enabled(employee.getEnabled())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                .build();
    }

    public static Employee dtoToDomain(EmployeeDto employeeDto) {
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
                .build();
    }

    public static List<EmployeeDto> domainToDtoList(List<Employee> employees) {
        return employees.stream().map(EmployeeMapper::domainToDto).toList();
    }

    public static List<Employee> dtoToDomainList(List<EmployeeDto> employeesDto) {
        return employeesDto.stream().map(EmployeeMapper::dtoToDomain).toList();
    }

}

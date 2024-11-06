package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.Employee;
import co.edu.usbcali.gymsoft.domain.Membership;
import co.edu.usbcali.gymsoft.dto.EmployeeDTO;
import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEmployeeRequest;

import java.util.List;

public class EmployeeMapper {

    public static EmployeeDTO domainToDto(Employee employee) {
        return EmployeeDTO.builder()
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
                .userId(employee.getUser() == null ? null : employee.getUser().getUserId())
                .build();
    }

    public static Employee dtoToDomain(EmployeeDTO employeeDTO){
        return Employee.builder()
                .employeeId(employeeDTO.getEmployeeId())
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .employeeType(employeeDTO.getEmployeeType())
                .address(employeeDTO.getAddress())
                .email(employeeDTO.getEmail())
                .phone(employeeDTO.getPhone())
                .enabled(employeeDTO.getEnabled())
                .createdAt(employeeDTO.getCreatedAt())
                .updatedAt(employeeDTO.getUpdatedAt())
                .build();
    }

    public static List<EmployeeDTO> domainToDtoList(List<Employee> employees){
        return employees.stream().map(EmployeeMapper::domainToDto).toList();
    }

    public static List<Employee> dtoToDomainList(List<EmployeeDTO> employeesDTO){
        return employeesDTO.stream().map(EmployeeMapper::dtoToDomain).toList();
    }

    public static Employee createEmployeeRequestToDomain(CreateEmployeeRequest createEmployeeRequest){
        return Employee.builder()

                .build();
    }

}

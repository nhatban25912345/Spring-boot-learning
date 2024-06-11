package org.example.springbootlearning.modal.mapper;

import org.example.springbootlearning.dto.EmployeeDto;
import org.example.springbootlearning.modal.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto maptoEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee maptoEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}

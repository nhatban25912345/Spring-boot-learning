package org.example.springbootlearning.modal.mapper;

import org.example.springbootlearning.dto.EmployeeDTO;
import org.example.springbootlearning.modal.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO maptoEmployeeDTO(Employee employee){
        if (employee == null){
            throw new NullPointerException("Employee is null");
        }
        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
    }

    public static Employee maptoEmployee(EmployeeDTO employeeDTO){
        if (employeeDTO == null){
            throw new NullPointerException("Employee is null");
        }
        return Employee.builder()
                .id(employeeDTO.getId())
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .build();
    }
}

package org.example.springbootlearning.service.impl;

import lombok.AllArgsConstructor;
import org.example.springbootlearning.dto.EmployeeDto;
import org.example.springbootlearning.exception.ResourceNotFoundException;
import org.example.springbootlearning.modal.entity.Employee;
import org.example.springbootlearning.modal.mapper.EmployeeMapper;
import org.example.springbootlearning.repository.EmployeeRepository;
import org.example.springbootlearning.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        employeeRepository.save(employee);

        return employeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with id: " + employeeId));
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::maptoEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeUpdate){
        Employee employee = employeeRepository.findById(employeeId)
                                                    .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with id: " + employeeId));
        employee.setFirstName(employeeUpdate.getFirstName());
        employee.setLastName(employeeUpdate.getLastName());
        employee.setEmail(employeeUpdate.getEmail());
        Employee updateEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }
}

package org.example.springbootlearning.service.impl;

import lombok.AllArgsConstructor;
import org.example.springbootlearning.dto.EmployeeDto;
import org.example.springbootlearning.modal.entity.Employee;
import org.example.springbootlearning.modal.mapper.EmployeeMapper;
import org.example.springbootlearning.repository.EmployeeRepository;
import org.example.springbootlearning.service.EmployeeService;
import org.springframework.stereotype.Service;

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
}

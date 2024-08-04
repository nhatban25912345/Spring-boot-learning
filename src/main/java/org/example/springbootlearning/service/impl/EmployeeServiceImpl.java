package org.example.springbootlearning.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootlearning.dto.EmployeeDTO;
import org.example.springbootlearning.exception.ResourceNotFoundException;
import org.example.springbootlearning.modal.entity.Employee;
import org.example.springbootlearning.modal.mapper.EmployeeMapper;
import org.example.springbootlearning.repository.EmployeeRepository;
import org.example.springbootlearning.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employee = EmployeeMapper.maptoEmployee(employeeDTO);
        employeeRepository.save(employee);

        return employeeDTO;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with id = " + employeeId));
        return EmployeeMapper.maptoEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees(){
        log.info("Repository : {}", employeeRepository);
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::maptoEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeUpdate){
        Employee employee = employeeRepository.findById(employeeId)
                                              .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with id = " + employeeId));
        employee.setFirstName(employeeUpdate.getFirstName() != null && !employeeUpdate.getFirstName().isEmpty() ? employeeUpdate.getFirstName() : employee.getFirstName());
        employee.setLastName(employeeUpdate.getLastName() != null ? employeeUpdate.getLastName() : employee.getLastName());
        employee.setEmail(employeeUpdate.getEmail() != null && !employeeUpdate.getEmail().isEmpty() ? employeeUpdate.getEmail() : employee.getEmail());
        Employee updateEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDTO(updateEmployeeObj);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }
}

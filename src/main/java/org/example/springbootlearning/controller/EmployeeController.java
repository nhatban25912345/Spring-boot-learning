package org.example.springbootlearning.controller;

import lombok.AllArgsConstructor;
import org.example.springbootlearning.dto.EmployeeDto;
import org.example.springbootlearning.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ems")
@AllArgsConstructor
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    //  build add employee api
    @PostMapping("/create-employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }
}

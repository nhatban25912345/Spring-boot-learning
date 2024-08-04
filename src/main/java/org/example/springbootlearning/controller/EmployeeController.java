package org.example.springbootlearning.controller;

import lombok.AllArgsConstructor;
import org.example.springbootlearning.dto.EmployeeDTO;
import org.example.springbootlearning.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ems")
@AllArgsConstructor
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    //  build add employee api
    @PostMapping("/create-employee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeDto){
        EmployeeDTO saveEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO employeeDto= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/all-employee")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(@RequestHeader("Authorization") String authorizationHeader){
        log.info("authorizationHeader: {}", authorizationHeader);
        List<EmployeeDTO> listEmployeeDTO = employeeService.getAllEmployees();
        return ResponseEntity.ok(listEmployeeDTO);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable Long id,
            @RequestBody @Valid EmployeeDTO employeeUpdate
    ) {
        EmployeeDTO employeeDto = employeeService.updateEmployee(id, employeeUpdate);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully!!!");
    }
}

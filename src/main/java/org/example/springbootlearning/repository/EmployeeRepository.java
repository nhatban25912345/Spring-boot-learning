package org.example.springbootlearning.repository;

import org.example.springbootlearning.dto.EmployeeDto;
import org.example.springbootlearning.modal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    EmployeeDto createEmployee(EmployeeDto employeeDto);
//    EmployeeDto findByEmployeeId(Long employeeId);
}

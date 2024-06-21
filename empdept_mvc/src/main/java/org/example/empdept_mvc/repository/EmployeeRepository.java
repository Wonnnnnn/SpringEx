package org.example.empdept_mvc.repository;

import org.example.empdept_mvc.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> findAll();
    Optional<Employee> findById(String id);
    Employee save(Employee employee);
    void deleteById(String empId);
}

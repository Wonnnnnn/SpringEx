package org.example.emp.repository;

import org.example.emp.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> findAll();
    Optional<Employee> findById(String id);
    void deleteById(String id);
    Employee save(Employee employee);
}

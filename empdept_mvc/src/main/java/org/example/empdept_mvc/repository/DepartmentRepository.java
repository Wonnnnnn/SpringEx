package org.example.empdept_mvc.repository;

import org.example.empdept_mvc.entity.Department;
import org.example.empdept_mvc.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    List<Department> findAll();
    Optional<Department> findById(int id);
    Optional<Department> findByName(String name);
    Department save(Department department);
}

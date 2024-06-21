package org.example.empdept_mvc.service;


import lombok.extern.slf4j.Slf4j;
import org.example.empdept_mvc.entity.Department;
import org.example.empdept_mvc.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int deptId) {
        return departmentRepository.findById(deptId).get();
    }

    @Transactional
    public Department setDepartment(Department department) {
        Department savedDepartment = departmentRepository.save(department);
        return savedDepartment;
    }
}

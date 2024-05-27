package org.example.emp.service;

import org.example.emp.dto.EmployeeDTO;
import org.example.emp.entity.Employee;
import org.example.emp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {this.employeeRepository = employeeRepository;}

    public List<Employee> getAllEmployees() {

    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getEmpId()).get();
        employee.setSalary(employeeDTO.getSalary());
        Employee saved = employeeRepository.save(employee);
        return saved;
    }

    public Employee getEmployee(String id) {
        return employeeRepository.findById(id).get();
    }

}

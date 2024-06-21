package org.example.empdept_mvc.service;

import lombok.extern.slf4j.Slf4j;
import org.example.empdept_mvc.entity.Department;
import org.example.empdept_mvc.entity.EmpType;
import org.example.empdept_mvc.entity.Employee;
import org.example.empdept_mvc.entity.Equipment;
import org.example.empdept_mvc.repository.DepartmentRepository;
import org.example.empdept_mvc.repository.EmployeeRepository;
import org.example.empdept_mvc.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;

//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String empId) {
        return employeeRepository.findById(empId).get();
    }

    @Transactional
    public Employee saveEmployeeWithDepartment(Employee employee, String depName, String seqNo) {
        Department department = departmentRepository.findByName(depName).get();
        if (department==null){
            throw new IllegalArgumentException("Department not found");
        }
        Equipment equipment = equipmentRepository.findByName(seqNo).get();
        if (equipment==null){
            throw new IllegalArgumentException("Equipment not found");
        }

        employee.setDepartment(department);
        employee.setEquipment(equipment);

        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee setEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    @Transactional
    public void removeEmployee(String empId){
        employeeRepository.deleteById(empId);
    }
}

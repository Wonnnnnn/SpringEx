package emp_test.service;

import emp_test.dto.EmployeeDTO;
import emp_test.entity.Employee;
import emp_test.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  public Employee getEmployeeById(String empId){
    return employeeRepository.findById(empId).get();
  }

  @Transactional
  public Employee setEmployee(Employee employee) {
    Employee savedEmployee = employeeRepository.save(employee);
    return savedEmployee;
  }

  @Transactional
  public Employee updateEmployee(String empId, EmployeeDTO employeeDto) {
    Employee orgEmployee = employeeRepository.findById(empId).get();
    orgEmployee.setSalary((long) employeeDto.getSalary());
    Employee updatedEmployee = employeeRepository.save(orgEmployee);
    return updatedEmployee;
  }

  @Transactional
  public void removeEmployee(String empId){
    employeeRepository.deleteById(empId);
  }

}

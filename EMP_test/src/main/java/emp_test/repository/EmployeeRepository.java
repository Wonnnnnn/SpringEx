package emp_test.repository;

import emp_test.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
  List<Employee> findAll();
  Optional<Employee> findById(String empId);
  void deleteById(String empId);
  // void update(Employee employee);
  Employee save(Employee employee);
}

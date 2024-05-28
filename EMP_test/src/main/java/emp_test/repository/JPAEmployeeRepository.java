package emp_test.repository;

import emp_test.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPAEmployeeRepository implements EmployeeRepository {
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Employee> findAll() {
    return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
  }

  @Override
  public Optional<Employee> findById(String empId) {
    return Optional.ofNullable(entityManager.find(Employee.class, empId));
  }

  @Override
  public void deleteById(String empId) {
    Employee fildEmployee = entityManager.find(Employee.class, empId);
    if (fildEmployee != null){
      entityManager.remove(fildEmployee);
    }
  }

  @Override
  public Employee save(Employee employee) {
    entityManager.persist(employee);
    return employee;
  }
}

package org.example.empdept_mvc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.empdept_mvc.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpRepository implements EmployeeRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(entityManager.find(Employee.class, id));
    }

    @Override
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public void deleteById(String empId) {
        Employee fildEmployee = entityManager.find(Employee.class, empId);
        if (fildEmployee != null){
            entityManager.remove(fildEmployee);
        }
    }
}

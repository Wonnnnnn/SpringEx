package org.example.emp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.emp.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPAEmployeeRepository implements EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> findAll() {
        List<Employee> result = em.createQuery("select e from Employee e", Employee.class).getResultList();
        return result;
    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(em.find(Employee.class, id));
    }

    @Override
    public void deleteById(String id) {
        Employee target = em.find(Employee.class, id);
        if(target != null) {
            em.remove(target);
        }
    }

    @Override
    public Employee save(Employee employee) {
        em.persist(employee);
        return em.find(Employee.class, employee);
    }
}

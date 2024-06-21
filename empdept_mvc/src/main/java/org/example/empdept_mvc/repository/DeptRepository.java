package org.example.empdept_mvc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.example.empdept_mvc.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeptRepository implements DepartmentRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Department> findAll() {
        return entityManager.createQuery("select e from Department e", Department.class).getResultList();
    }

    @Override
    public Optional<Department> findByName(String name) {
        try {
            Department department = entityManager.createQuery("SELECT d FROM Department d WHERE d.deptName = :name", Department.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return Optional.of(department);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Department> findById(int id) {
        return Optional.ofNullable(entityManager.find(Department.class, id));
    }

    @Override
    public Department save(Department department) {
        entityManager.persist(department);
        return department;
    }
}

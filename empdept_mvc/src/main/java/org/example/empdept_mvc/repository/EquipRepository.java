package org.example.empdept_mvc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.example.empdept_mvc.entity.Department;
import org.example.empdept_mvc.entity.Equipment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EquipRepository implements EquipmentRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Equipment> findAll() {
        return entityManager.createQuery("select e from Equipment e", Equipment.class).getResultList();
    }

    @Override
    public Optional<Equipment> findById(int id) {
        return Optional.ofNullable(entityManager.find(Equipment.class, id));
    }

    @Override
    public Equipment save(Equipment equipment) {
        entityManager.persist(equipment);
        return equipment;
    }

    @Override
    public Optional<Equipment> findByName(String seqno) {
        try {
            Equipment equipment = entityManager.createQuery("SELECT e FROM Equipment e WHERE e.seqNo = :seqno", Equipment.class)
                    .setParameter("seqno", seqno)
                    .getSingleResult();
            return Optional.of(equipment);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Equipment> findList() {
//        return entityManager.createQuery("select e from Equipment e where e.id not in(select emp.id from employee emp)", Equipment.class).getResultList();
        String sql = "SELECT e.* FROM Equipment e WHERE e.id NOT IN (SELECT emp.id FROM employee emp)";
        return entityManager.createNativeQuery(sql, Equipment.class).getResultList();
    }
}

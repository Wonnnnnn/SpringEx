package org.example.empdept_mvc.repository;

import org.example.empdept_mvc.entity.Employee;
import org.example.empdept_mvc.entity.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository {
    List<Equipment> findAll();
    List<Equipment> findList();
    Optional<Equipment> findById(int id);
    Optional<Equipment> findByName(String name);
    Equipment save(Equipment equipment);
}

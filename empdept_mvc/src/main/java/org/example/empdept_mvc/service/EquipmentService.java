package org.example.empdept_mvc.service;

import lombok.extern.slf4j.Slf4j;
import org.example.empdept_mvc.entity.Equipment;
import org.example.empdept_mvc.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

//    public EquipmentService(EquipmentRepository equipmentRepository) {
//        this.equipmentRepository = equipmentRepository;
//    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public List<Equipment> getAvailEquipment() {
        return equipmentRepository.findList();
    }

    public Equipment getEquipmentById(int id) {
        return equipmentRepository.findById(id).get();
    }

    @Transactional
    public Equipment setEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }
}

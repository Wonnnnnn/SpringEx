package org.example.empdept_mvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.empdept_mvc.entity.Department;
import org.example.empdept_mvc.entity.Equipment;
import org.example.empdept_mvc.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipments")
public class EquipmentController {
    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/add")
    public String addEquipment(Model model){
        model.addAttribute("equipment", new Equipment());
        return "equipment/EquipmentForm";
    }

    @PostMapping("/add")
    @Operation(summary = "add a Equipment", description = "Add a equipement information")
    public String addEquipment(@ModelAttribute Equipment equipment){
        equipmentService.setEquipment(equipment);
        return "redirect:/employees";
    }
}

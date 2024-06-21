package org.example.empdept_mvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.empdept_mvc.entity.Department;
import org.example.empdept_mvc.entity.Employee;
import org.example.empdept_mvc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/add")
    public String addDepartment(Model model){
        model.addAttribute("department", new Department());
        return "department/DepartmentForm";
    }

    @PostMapping("/add")
    @Operation(summary = "add a department", description = "Add a department information")
    public String addDpartment(@ModelAttribute Department department){
        departmentService.setDepartment(department);
        return "redirect:/employees";
    }
}


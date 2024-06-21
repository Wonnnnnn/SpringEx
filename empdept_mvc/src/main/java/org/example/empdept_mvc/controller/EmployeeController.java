package org.example.empdept_mvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.empdept_mvc.entity.Employee;
import org.example.empdept_mvc.service.DepartmentService;
import org.example.empdept_mvc.service.EmployeeService;
import org.example.empdept_mvc.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final EquipmentService equipmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              DepartmentService departmentService,
                              EquipmentService equipmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.equipmentService = equipmentService;
    }

    @GetMapping
    @Operation(summary = "Get all employees", description = "Get a list of all employees")
    public String getAllEmployees(Model model){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("employees", allEmployees);
        return "employee/EmployeeAll";
    }

    @GetMapping("/info/{empId}")
    @Operation(summary = "Get 1 employee", description = "Get a employee information")
    public String getEmployeeInfo(@PathVariable String empId, Model model){
        Employee employee = employeeService.getEmployeeById(empId);
        model.addAttribute("employee", employee);
        return "employee/EmployeeInfo";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("equipments", equipmentService.getAvailEquipment());
        model.addAttribute("employee", new Employee());
        return "employee/EmployeeForm";
    }

    @PostMapping("/add")
    @Operation(summary = "add a employee", description = "Add a employee information")
    public String addEmployee(@ModelAttribute Employee employee,
                              @RequestParam("deptName") String deptName,
                              @RequestParam("seqNo") String seqNo){
        employeeService.saveEmployeeWithDepartment(employee, deptName, seqNo);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{empId}")
    @Operation(summary = "Delete employee", description = "Delete a employee information")
    public String deleteEmployee(@PathVariable String empId){
        employeeService.removeEmployee(empId);
        return "redirect:/employees";
    }
}

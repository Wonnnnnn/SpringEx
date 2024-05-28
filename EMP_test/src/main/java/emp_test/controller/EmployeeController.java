package emp_test.controller;

import emp_test.dto.EmployeeDTO;
import emp_test.entity.Employee;
import emp_test.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
  private final EmployeeService employeeService;

  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  @Operation(summary = "Get all employees", description = "Get a list of all employees")
  public String getAllEmployees(Model model){
    List<Employee> allEmployees = employeeService.getAllEmployees();
    model.addAttribute("employees", allEmployees);
    return "employee/EmployeeList";
  }

  @GetMapping("/info/{empId}")
  @Operation(summary = "Get 1 employee", description = "Get a employee information")
  public String getEmployeeInfo(@PathVariable String empId, Model model){
    Employee employee = employeeService.getEmployeeById(empId);
    model.addAttribute("employee", employee);
    return "employee/EmployeeInfo";
  }

  @GetMapping("/add")
  public String addEmployee(){
    return "employee/EmployeeForm";
  }

  @PostMapping("/add")
  @Operation(summary = "add a employee", description = "Add a employee information")
  public String addEmployee(@ModelAttribute Employee employee){
    employeeService.setEmployee(employee);
    return "redirect:/employees";
  }

  @GetMapping("/update/{empId}")
  public String updateEmployee(@PathVariable String empId, Model model){
    Employee employee = employeeService.getEmployeeById(empId);
    model.addAttribute("employee", employee);
    return "employee/EmployeeUpdateForm";
  }

  @PostMapping("/update/{empId}")
  @Operation(summary = "Update a employee ", description = "Update a employee information")
  public String updateEmployee(@PathVariable String empId, @ModelAttribute EmployeeDTO employeeDto){
    employeeService.updateEmployee(empId, employeeDto);
    return "redirect:/employees";
  }

  @GetMapping("/delete/{empId}")
  @Operation(summary = "Delete employee", description = "Delete a employee information")
  public String deleteEmployee(@PathVariable String empId){
    employeeService.removeEmployee(empId);
    return "redirect:/employees";
  }
}

package com.app.DailyStatus.controller;

import com.app.DailyStatus.model.Employee;
import com.app.DailyStatus.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/register")
    public Employee registerEmployee(@RequestBody Employee employee){
        return employeeService.registerEmployee(employee);
    }


    @GetMapping("/{email}")
    public Optional<Employee> getEmployeeEmail(@PathVariable String email){
        return employeeService.findByEmail(email);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
}

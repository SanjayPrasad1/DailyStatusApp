package com.app.DailyStatus.controller;

import com.app.DailyStatus.model.Employee;
import com.app.DailyStatus.repository.EmployeeRepository;
import com.app.DailyStatus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Employee emp) {
        employeeService.register(emp);
        return ResponseEntity.ok("Employee registered: ");
    }

    @GetMapping("/by-email")
    public ResponseEntity<Employee> getByEmail(@RequestParam String email) {
        return employeeService.findByEmail(email).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        return employeeService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/byEmpId/{id}")
    public ResponseEntity<String> deletebyId(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted employee with id: " + id);
    }
}
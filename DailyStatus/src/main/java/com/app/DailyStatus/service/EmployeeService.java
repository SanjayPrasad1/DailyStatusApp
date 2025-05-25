package com.app.DailyStatus.service;

import com.app.DailyStatus.model.Employee;
import com.app.DailyStatus.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void register(Employee emp){
    employeeRepository.save(emp);
    }

    public Optional<Employee> findByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    public Optional<Employee> findById(int id){
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(int id){
        employeeRepository.deleteEmployee(id);
    }

}

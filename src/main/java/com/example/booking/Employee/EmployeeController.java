package com.example.booking.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired private EmployeeRepository repository;
    @Autowired private EmployeeService service;
    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public List<Employee> findOne(@PathVariable(value = "id") Integer id) {
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody Employee newEmployee) {
        newEmployee.setPassword(this.passwordEncoder.encode(newEmployee.getPassword()));
        newEmployee.setDepartment(service.getEmployeeDepartment(newEmployee.getDepartment().getId()));
        this.repository.save(newEmployee);
    }

    @DeleteMapping("{id}")
    public static String deleteOne(@PathVariable(value = "id") String id) {
        return String.format("Deleting (%s)", id);
    }

    @PatchMapping("{id}")
    public static String updateOne(@PathVariable(value = "id") String id) {
        return String.format("Updating (%s)", id);
    }
    
}

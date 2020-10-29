package com.example.booking.Department;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/departments")
public class DepartmentController {

    @GetMapping
    public static String findAll() {
        return "Get many";
    }

    @GetMapping("{id}")
    public static String findOne(@PathVariable(value = "id") Integer id) {
        return String.format("Get one (%s)", Integer.toString(id));
    }

    @PostMapping
    public static String create(@RequestBody Department newDepartment){
        return String.format("Adding new (%s)", newDepartment.getId());
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

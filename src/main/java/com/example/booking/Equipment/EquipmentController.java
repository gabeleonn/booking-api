package com.example.booking.Equipment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/equipments")
public class EquipmentController {
    
    @GetMapping
    public String hello() {
        return "Hello World!";
    }
}

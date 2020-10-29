package com.example.booking.Equipment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EquipmentController {
    
    @GetMapping
    public String hello() {
        return "Hello World!";
    }
}

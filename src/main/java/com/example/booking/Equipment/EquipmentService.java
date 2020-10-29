package com.example.booking.Equipment;

import org.springframework.stereotype.Service;

@Service
public class EquipmentService implements IEquipmentService {
    @Override
    public String method() {
        return "Methods";
    }
}

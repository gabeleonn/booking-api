package com.example.booking.Department;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {
    
    @Override
    public String method() {
        return "Methods";
    }
}

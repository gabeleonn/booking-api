package com.example.booking.Employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    
    @Override
    public String method() {
        return "Methods";
    }
}

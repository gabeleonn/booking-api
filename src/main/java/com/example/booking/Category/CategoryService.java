package com.example.booking.Category;

import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    
    @Override
    public String findAll() {
        return "Hello"; 
    }
}

package com.example.booking.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquimentRepository extends JpaRepository<Repository, Integer> {
    
}

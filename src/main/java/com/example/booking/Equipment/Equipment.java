package com.example.booking.Equipment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.example.booking.Category.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 12)
    private String code;

    @Column
    private String description;

    @Column(name = "is_active")
    @Builder.Default
    private Boolean isActive = true;

    @Column(name = "in_use")
    @Builder.Default
    private Boolean inUse = false;

    @OneToOne
    private Category category;

    @Column(name = "bought_at")
    private Date boughtAt;

    @Column(name = "last_maintance")
    private Date lastMaintance;

    // preUpdate, predelete, etc.
    @PrePersist
    void createdAt() {
        this.boughtAt = this.lastMaintance = new Date();
    }
    
}

package com.example.booking.Ticket;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.example.booking.Employee.Employee;
import com.example.booking.Equipment.Equipment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Employee employee;

    @OneToOne
    private Equipment equipment;

    @Column(name="withdraw_date")
    private Date widthdrawDate;

    @Column(name="return_date")
    private Date returnDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    void createdAt() {
        Calendar c = Calendar.getInstance();
        this.widthdrawDate = new Date();
        c.setTime(this.widthdrawDate);
        c.add(Calendar.DAY_OF_MONTH, 1);
        this.returnDate = c.getTime();
    }
}

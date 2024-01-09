package com.utcn.employeeapplication.employee;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Getter
@Setter

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String name;
    private Integer departmentID;
    private Integer managerID;
    private String email;

    @Column(updatable=false, nullable=false)
    @CreationTimestamp
    private Date enrollDate;

}

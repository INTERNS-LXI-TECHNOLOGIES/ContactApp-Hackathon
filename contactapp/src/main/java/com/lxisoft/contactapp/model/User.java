package com.lxisoft.contactapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String contactName;
    @Column
    private double phoneNumber;
    @Column
    private String email;
}

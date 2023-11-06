package com.lxisoft.contactapp.contactapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DomainUser {
    @Id
    private Long id;
    private String userName;

    // Add other fields as needed

    // No need to manually write getters, setters, constructors, equals, hashCode, or toString methods
}

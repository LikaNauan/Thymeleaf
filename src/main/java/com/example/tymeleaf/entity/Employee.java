package com.example.tymeleaf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "test", schema = "whiskey")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    private String name;

    @Min(value = 0, message = "Age should be greater then 0")
    @Max(value = 100, message = "I guess you're not that old.")
    public int age;

    @NotEmpty(message = "Name should not be empty")
    @Email(message = "Email should be valid")
    private String email;

}
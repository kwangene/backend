package com.student.backend.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long indexNumber;
    @Column(name="first_Name",nullable = false)
    private String firstName;
    @Column(name="last_Name")
    private String lastName;
    @Column(name="email")
    private String email;

    public Student() {
    }
}

package com.springboot.university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_details")
public class Student {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "first_name")
    String first_name;
    @Column(name = "last_name")
    String last_name;
    @Column(name = "department")
    String department;
    @Column(name = "branch")
    String branch;
    @Column(name = "joining_date")
    String joining_date;
}
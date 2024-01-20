package com.hardsontessi.scratch;

import jakarta.persistence.*;

@Entity
@Table(name = "students_table")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            updatable = false
    )
    private String fistName;

    @Column(
            name = "c_lastname",
            length = 25,
            unique = true
    )
    private String lastName;

    private String email;

    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(Integer id, String fistName, String lastName, String email, int age) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}

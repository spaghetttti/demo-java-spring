package com.example.demo.user;

import java.time.LocalDate;

public class User {
    private String name;
    private Long id;
    private String email;
    private LocalDate dob;
    private Integer age;

    public User() {
    }

    public User(String name, Long id, String email, LocalDate dob, Integer age) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public User(String name, String email, LocalDate dob, Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
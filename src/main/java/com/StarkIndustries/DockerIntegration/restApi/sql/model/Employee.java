package com.StarkIndustries.DockerIntegration.restApi.sql.model;

import jakarta.persistence.*;

@Entity(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private String contact;

    @Column(name = "password")
    private String password;

    public Employee(Long empId, String name, String username, String email, String contact, String password) {
        this.empId = empId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    public Employee(String name, String username, String email, String contact, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    public Employee() {

    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

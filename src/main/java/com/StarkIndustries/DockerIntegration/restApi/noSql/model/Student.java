package com.StarkIndustries.DockerIntegration.restApi.noSql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

    @Id
    private String studentId;

    private String name;

    private String email;

    private String username;

    private String department;

    private String password;

    public Student(String studentId, String name, String email, String username, String department, String password) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.department = department;
        this.password = password;
    }

    public Student(String name, String email, String username, String department, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.department = department;
        this.password = password;
    }

    public Student() {

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

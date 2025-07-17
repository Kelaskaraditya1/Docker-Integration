package com.StarkIndustries.DockerIntegration.restApi.sql.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    private String empId;

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

}

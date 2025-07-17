package com.StarkIndustries.DockerIntegration.restApi.noSql.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    private String studentId;

    private String name;

    private String email;

    private String username;

    private String department;

    private String password;


}

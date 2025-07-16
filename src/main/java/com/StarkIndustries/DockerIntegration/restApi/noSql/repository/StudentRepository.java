package com.StarkIndustries.DockerIntegration.restApi.noSql.repository;

import com.StarkIndustries.DockerIntegration.restApi.noSql.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
}

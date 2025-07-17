package com.StarkIndustries.DockerIntegration.restApi.noSql.service;

import com.StarkIndustries.DockerIntegration.restApi.noSql.model.Student;
import com.StarkIndustries.DockerIntegration.restApi.noSql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    @CachePut(key = "#student.studentId",value = "student")
    @CacheEvict(value = "allStudents",allEntries = true)
    public Student addStudent(Student student){
        String studentId = UUID.randomUUID().toString();

        if(!this.studentRepository.existsById(studentId)){
            student.setStudentId(studentId);
            return this.studentRepository.save(student);
        }
        return null;
    }

    @Cacheable(value = "allStudents")
    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }

    @Cacheable(key = "#studentId",value = "student")
    public Student getStudent(String studentId){
        if(this.studentRepository.existsById(studentId))
            return this.studentRepository.findById(studentId).get();
        return null;
    }
}

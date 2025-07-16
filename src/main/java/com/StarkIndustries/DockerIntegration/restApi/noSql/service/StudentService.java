package com.StarkIndustries.DockerIntegration.restApi.noSql.service;

import com.StarkIndustries.DockerIntegration.restApi.noSql.model.Student;
import com.StarkIndustries.DockerIntegration.restApi.noSql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public Student addStudent(Student student){
        student.setStudentId(UUID.randomUUID().toString());
        return this.studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }

    public Student getStudent(String studentId){
        if(this.studentRepository.existsById(studentId))
            return this.studentRepository.findById(studentId).get();
        return null;
    }
}

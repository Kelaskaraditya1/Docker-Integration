package com.StarkIndustries.DockerIntegration.restApi.noSql.controller;

import com.StarkIndustries.DockerIntegration.restApi.noSql.model.Student;
import com.StarkIndustries.DockerIntegration.restApi.noSql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @GetMapping("/greetings")
    public ResponseEntity<?> greetings(){
        return ResponseEntity.status(HttpStatus.OK).body("Greetings,I am Optimus Prime!!");
    }

    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        Student student1 = this.studentService.addStudent(student);
        if(student1!=null)
            return ResponseEntity.status(HttpStatus.OK).body(student1);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to add Student");
    }

    @GetMapping("/get-student/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable("studentId") String studentId){
        Student student = this.studentService.getStudent(studentId);
        if(student!=null)
            return ResponseEntity.status(HttpStatus.OK).body(student);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student doesn't exist");
    }

    @GetMapping("/get-students")
    public ResponseEntity<?> getStudents(){
        List<Student> studentList = this.studentService.getStudents();
        if(studentList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(studentList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Add student's first");
    }

}

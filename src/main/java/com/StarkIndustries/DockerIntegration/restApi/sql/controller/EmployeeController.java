package com.StarkIndustries.DockerIntegration.restApi.sql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.StarkIndustries.DockerIntegration.restApi.sql.model.Employee;
import com.StarkIndustries.DockerIntegration.restApi.sql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/greetings-employee")
    public ResponseEntity<?> greetings() {
        return ResponseEntity.status(HttpStatus.OK).body("Greetings, I am Iron Man!!");
    }

    @PostMapping("/add-employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        if (savedEmployee != null)
            return ResponseEntity.status(HttpStatus.OK).body(savedEmployee);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add Employee");
    }

    @GetMapping("/get-employee/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("employeeId") String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null)
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee doesn't exist");
    }

    @GetMapping("/get-employees")
    public ResponseEntity<?> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (!employees.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(employees);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employees found");
    }
}


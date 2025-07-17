package com.StarkIndustries.DockerIntegration.restApi.sql.service;

import com.StarkIndustries.DockerIntegration.restApi.sql.model.Employee;
import com.StarkIndustries.DockerIntegration.restApi.sql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @CachePut(key = "#employee.empId",value = "employee")
    @CacheEvict(value = "allEmployees",allEntries = true)
    public Employee addEmployee(Employee employee) {

        String empId = UUID.randomUUID().toString();
        if(!this.employeeRepository.existsById(empId)){
            employee.setEmpId(empId);
            return this.employeeRepository.save(employee);
        }
        return null;
    }

    @Cacheable(value = "allEmployees")
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Cacheable(key = "empId",value = "employee")
    public Employee getEmployeeById(String empId) {
        if(this.employeeRepository.existsById(empId))
            return this.employeeRepository.findById(empId).get();
        return null;
    }
}

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

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @CachePut(key = "#employee.empId",value = "employee")
    @CacheEvict(value = "allEmployees",allEntries = true)
    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Cacheable(value = "allEmployees")
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Cacheable(key = "empId",value = "employee")
    public Employee getEmployeeById(Long empId) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(empId);
        return optionalEmployee.orElse(null);
    }
}

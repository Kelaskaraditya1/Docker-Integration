package com.StarkIndustries.DockerIntegration.restApi.sql.repository;

import com.StarkIndustries.DockerIntegration.restApi.sql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
}

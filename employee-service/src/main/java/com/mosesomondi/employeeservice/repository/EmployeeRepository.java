package com.mosesomondi.employeeservice.repository;

import com.mosesomondi.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}

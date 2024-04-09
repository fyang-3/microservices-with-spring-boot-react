package com.mosesomondi.employeeservice.service;

import com.mosesomondi.employeeservice.DTO.EmployeeDTO;
import com.mosesomondi.employeeservice.DTO.EmployeeWithDepartmentDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeWithDepartmentDTO getEmployeeWithDepartmentById(Long employeeId);
}

package com.mosesomondi.departmentservice.service;

import com.mosesomondi.departmentservice.DTO.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentByCode(String departmentCode);
}

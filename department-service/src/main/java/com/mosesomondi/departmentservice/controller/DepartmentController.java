package com.mosesomondi.departmentservice.controller;

import com.mosesomondi.departmentservice.DTO.DepartmentDTO;
import com.mosesomondi.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartmentDTO = departmentService.saveDepartment(departmentDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedDepartmentDTO);
    }

    // Get department REST API
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("department-code") String departmentCode) {
        DepartmentDTO fetchedDepartment = departmentService.getDepartmentByCode(departmentCode);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(fetchedDepartment);
    }


}

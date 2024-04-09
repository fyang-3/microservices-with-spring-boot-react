package com.mosesomondi.employeeservice.controller;

import com.mosesomondi.employeeservice.DTO.EmployeeDTO;
import com.mosesomondi.employeeservice.DTO.EmployeeWithDepartmentDTO;
import com.mosesomondi.employeeservice.exception.EmployeeNotFoundException;
import com.mosesomondi.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class employeeController {
    private EmployeeService employeeService;

    // Save employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }

    // GET employee REST API
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeWithDepartmentDTO> getEmployee(@PathVariable("employeeId") Long employeeId) {
        EmployeeWithDepartmentDTO fetchedEmployeeWithDepartment = employeeService.getEmployeeWithDepartmentById(employeeId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(fetchedEmployeeWithDepartment);
    }


}

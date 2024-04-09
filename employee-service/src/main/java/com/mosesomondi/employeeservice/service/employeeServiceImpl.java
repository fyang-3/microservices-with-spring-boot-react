package com.mosesomondi.employeeservice.service;

import com.mosesomondi.employeeservice.DTO.DepartmentDTO;
import com.mosesomondi.employeeservice.DTO.EmployeeDTO;
import com.mosesomondi.employeeservice.DTO.EmployeeWithDepartmentDTO;
import com.mosesomondi.employeeservice.entity.Employee;
import com.mosesomondi.employeeservice.exception.EmployeeNotFoundException;
import com.mosesomondi.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class employeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //private WebClient webClient;

    //private WebClient.Builder webClientBuilder;
    private WebClient webClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO)
    {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );

        Employee employeeSaved = employeeRepository.save(employee);

        EmployeeDTO employeeSavedDTO = new EmployeeDTO(
                employeeSaved.getId(),
                employeeSaved.getFirstName(),
                employeeSaved.getLastName(),
                employeeSaved.getEmail(),
                employeeSaved.getDepartmentCode()
        );

        return employeeSavedDTO;
    }

    @Override
    public EmployeeWithDepartmentDTO getEmployeeWithDepartmentById(Long employeeId) {

        Employee fetchedEmployee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new EmployeeNotFoundException("The employee with id:" + employeeId + " doesn't exit")
        );

        DepartmentDTO departmentDTO = null;

        // Check if the employee has a department associated with them
        if (fetchedEmployee.getDepartmentCode() != null && !fetchedEmployee.getDepartmentCode().isEmpty()) {
            // Fetch department details if department code exists
            departmentDTO = webClient.get()
                    .uri("http://department-service/api/departments/" + fetchedEmployee.getDepartmentCode())
                    .retrieve()
                    .bodyToMono(DepartmentDTO.class)
                    .block();
        }

        EmployeeDTO employeeDTO = new EmployeeDTO(
                fetchedEmployee.getId(),
                fetchedEmployee.getFirstName(),
                fetchedEmployee.getLastName(),
                fetchedEmployee.getEmail(),
                fetchedEmployee.getDepartmentCode()
        );

        EmployeeWithDepartmentDTO employeeWithDepartmentDTO = new EmployeeWithDepartmentDTO();
        employeeWithDepartmentDTO.setEmployeeDTO(employeeDTO);
        employeeWithDepartmentDTO.setDepartmentDTO(departmentDTO);

        return employeeWithDepartmentDTO;
    }
}

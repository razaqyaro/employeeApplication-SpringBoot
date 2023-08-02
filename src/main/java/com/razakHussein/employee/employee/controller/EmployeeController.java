package com.razakHussein.employee.employee.controller;

import com.razakHussein.employee.employee.DTOmodel.EmployeeDTO;
import com.razakHussein.employee.employee.DTOmodel.EmployeeMapper;
import com.razakHussein.employee.employee.DTOmodel.EmployeeResponse;
import com.razakHussein.employee.employee.model.Department;
import com.razakHussein.employee.employee.repository.DepartmentRepository;
import com.razakHussein.employee.employee.repository.EmployeeRepository;
import com.razakHussein.employee.employee.service.DepartmentService;
import com.razakHussein.employee.employee.service.EmployeeService;
import com.razakHussein.employee.employee.model.Employee;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController
{

    private final EmployeeService service;
    private final EmployeeMapper employeeMapper;
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @PostMapping
    public EmployeeDTO save(@RequestBody @Valid EmployeeDTO employeeDTO)
    {
        return service.save(employeeDTO);
    }
    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") int id)
    {
        EmployeeDTO employeeDTO = service.findById(id);
        return EmployeeDTO.builder()
                .phone(employeeDTO.getPhone())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .firstName(employeeDTO.getFirstName())
                .id(employeeDTO.getId())
                .build();
    }
    @GetMapping
    public List<Employee>  findAllEmployees()
    {
        return service.findAllEmployees();

    }
    @PutMapping("/{id}")
    public EmployeeDTO update(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable("id") Integer id)

    {
       return service.update(employeeDTO, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id)
    {
        service.delete(id);
    }
}

//Object mapper : study that
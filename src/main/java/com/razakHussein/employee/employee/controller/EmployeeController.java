package com.razakHussein.employee.employee.controller;

import com.razakHussein.employee.employee.DTOmodel.EmployeeDTO;
import com.razakHussein.employee.employee.DTOmodel.EmployeeMapper;
import com.razakHussein.employee.employee.model.Department;
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
    @PostMapping
    public EmployeeDTO save(@RequestBody @Valid EmployeeDTO employeeDTO)
    {
        Employee employee = employeeMapper.fromDTO(employeeDTO);
        if(employeeDTO.getDepartment() != null && employeeDTO.getDepartment().getId()!= null)
        {
            Department department = departmentService.findById(employeeDTO.getId());
            employee.setDepartment(department);
        }
        Employee savedEmployee = service.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }
    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") int id)
    {
        Employee employee = service.findById(id);
        return employeeMapper.toDTO(employee);
    }
    @GetMapping
    public List<EmployeeDTO> findAllEmployees()
    {
        List<Employee> employees = service.findAllEmployees();
        return employees.stream()
                .map(employeeMapper::toDTO)
                .toList();
    }
    @PutMapping("/{id}")
    public EmployeeDTO update(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable("id") Integer id)

    {
        Employee employee = employeeMapper.fromDTO(employeeDTO);
        Employee updatedEmployee = service.update(employee, id);
        return employeeMapper.toDTO(updatedEmployee);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id)
    {
        service.delete(id);
    }
}

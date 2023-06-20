package com.razakHussein.employee.employee.controller;

import com.razakHussein.employee.employee.DTOmodel.DepartmentDTO;
import com.razakHussein.employee.employee.DTOmodel.DepartmentMapper;
import com.razakHussein.employee.employee.model.Department;
import com.razakHussein.employee.employee.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController
{
    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    @PostMapping
    public DepartmentDTO save(@RequestBody DepartmentDTO departmentDTO)
    {
        Department department = departmentMapper.fromDTO(departmentDTO);
        Department savedDepartment = departmentService.save(department);
        return departmentMapper.toDTO(savedDepartment);
    }

    @GetMapping("/{id}")
    public DepartmentDTO findById(@PathVariable("id") int id)
    {
        Department department = departmentService.findById(id);
        return departmentMapper.toDTO(department);
    }

    @GetMapping
    public List<DepartmentDTO> findAllDepartments()
    {
        List<Department> departments = departmentService.findAllDepartments();
        return departments.stream()
                .map(departmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public DepartmentDTO update(@RequestBody @Valid DepartmentDTO departmentDTO,@Valid @PathVariable("id") Integer id)
    {
        Department department = departmentMapper.fromDTO(departmentDTO);
        Department updatedDepartment = departmentService.update(department, id);
        return departmentMapper.toDTO(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id)
    {
        departmentService.delete(id);
    }

    @PostMapping("/{departmentId}")
    public DepartmentDTO addEmployeeToDepartment(
            @PathVariable("departmentId") Integer departmentId,
            @RequestParam("employeeId") Integer employeeId
    ) {
        Department department = departmentService.addEmployeeToDepartment(departmentId, employeeId);
        return departmentMapper.toDTO(department);
    }
}

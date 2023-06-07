package com.razakHussein.employee.employee.DTOmodel;

import com.razakHussein.employee.employee.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper
{
    public DepartmentDTO toDTO(Department department)
    {
        return new DepartmentDTO(department.getId(), department.getName());
    }

    public Department fromDTO(DepartmentDTO departmentDTO)
    {
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        return department;
    }

}

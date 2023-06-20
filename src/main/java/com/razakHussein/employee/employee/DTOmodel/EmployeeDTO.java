package com.razakHussein.employee.employee.DTOmodel;

import com.razakHussein.employee.employee.model.Department;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO
{

    private Integer id;


    private String firstName;


    private String lastName;


    private String email;

    private String phone;

    //private Integer departmentId;

    private Department department;

}

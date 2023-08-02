package com.razakHussein.employee.employee.DTOmodel;

import com.razakHussein.employee.employee.model.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class EmployeeResponse
{

    private Integer id;


    private String firstName;


    private String lastName;


    private String email;

    private String phone;

    //private Integer departmentId;

    private Department department;
}

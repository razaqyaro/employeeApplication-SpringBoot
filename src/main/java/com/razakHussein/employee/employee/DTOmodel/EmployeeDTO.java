package com.razakHussein.employee.employee.DTOmodel;

import com.razakHussein.employee.employee.model.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO
{

    private Integer id;


    private String firstName;


    private String lastName;


    private String email;

    private String phone;

    private Integer departmentId;

}

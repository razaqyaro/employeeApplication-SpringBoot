package com.razakHussein.employee.employee.model;

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
}

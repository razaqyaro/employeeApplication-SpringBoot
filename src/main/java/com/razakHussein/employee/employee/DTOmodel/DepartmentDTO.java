package com.razakHussein.employee.employee.DTOmodel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO
{
    private Integer id;

    @NotBlank(message = "Department name required")
    private String name;
}

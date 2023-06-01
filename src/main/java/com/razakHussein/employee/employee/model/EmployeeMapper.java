package com.razakHussein.employee.employee.model;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper
{
    public EmployeeDTO toDTO(Employee employee)
    {
        return new EmployeeDTO(
          employee.getId(),
          employee.getFirstName(),
          employee.getLastName(),
          employee.getEmail(),
          employee.getPhone()
        );
    }

    public Employee fromDTO(EmployeeDTO employeeDTO)
    {
        return new Employee(
          employeeDTO.getId(),
          employeeDTO.getFirstName(),
          employeeDTO.getLastName(),
          employeeDTO.getEmail(),
          employeeDTO.getPhone()
        );
    }
}

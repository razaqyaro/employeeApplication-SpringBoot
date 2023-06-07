package com.razakHussein.employee.employee.DTOmodel;

import com.razakHussein.employee.employee.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


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
          employee.getPhone(),
          employee.getDepartment()
        );

    }

    public Employee fromDTO(EmployeeDTO employeeDTO)
    {
        return new Employee(
          employeeDTO.getId(),
          employeeDTO.getFirstName(),
          employeeDTO.getLastName(),
          employeeDTO.getEmail(),
          employeeDTO.getPhone(),
          employeeDTO.getDepartment()
        );


    }

    public List<EmployeeDTO> toDTOList(List<Employee> employees)
    {
        return employees.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Employee> fromDTOList(List<EmployeeDTO> employeeDTOs)
    {
        return employeeDTOs.stream()
                .map(this::fromDTO)
                .collect(Collectors.toList());
    }
}

package com.razakHussein.employee.employee.DTOmodel;

import com.razakHussein.employee.employee.model.Department;
import com.razakHussein.employee.employee.model.Employee;
import com.razakHussein.employee.employee.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class EmployeeMapper
{
    private final DepartmentRepository departmentRepository;
    public EmployeeDTO toDTO(Employee employee)
    {
        return new EmployeeDTO(
          employee.getId(),
          employee.getFirstName(),
          employee.getLastName(),
          employee.getEmail(),
          employee.getPhone(),
          employee.getDepartment().getId()

        );

    }

    public Employee fromDTO(EmployeeDTO employeeDTO)
    {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());

        Department department = new Department();
        department.setId(employeeDTO.getDepartmentId());
        employee.setDepartment(department);

        return employee;

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

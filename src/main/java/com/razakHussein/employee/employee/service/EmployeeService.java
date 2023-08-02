package com.razakHussein.employee.employee.service;

import com.razakHussein.employee.employee.DTOmodel.EmployeeDTO;
import com.razakHussein.employee.employee.model.Employee;

import java.util.List;

public interface EmployeeService
{
    EmployeeDTO save(EmployeeDTO employeeDTO);
    List<Employee> findAllEmployees();
    EmployeeDTO findById(int id);
    EmployeeDTO update(EmployeeDTO employeeDTO, Integer id);
    void delete(int id);
}

package com.razakHussein.employee.employee.service;

import com.razakHussein.employee.employee.model.Employee;

import java.util.List;

public interface EmployeeService
{
    Employee save(Employee employee);
    List<Employee> findAllEmployees();
    Employee findById(int id);
    Employee update(Employee employee, Integer id);
    void delete(int id);
}

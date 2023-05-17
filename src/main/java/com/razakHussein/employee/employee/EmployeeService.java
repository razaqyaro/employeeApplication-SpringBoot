package com.razakHussein.employee.employee;

import java.util.List;

public interface EmployeeService
{
    Employee save(Employee employee);
    List<Employee> findAllEmployees();
    Employee findById(int id);
    Employee update(Employee employee);
    void delete(int id);
}

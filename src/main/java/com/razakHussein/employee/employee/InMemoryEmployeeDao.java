package com.razakHussein.employee.employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryEmployeeDao
{
    private final List<Employee> EMPLOYEES = new ArrayList<>();

    public List<Employee> findAllEmployees()
    {
        return EMPLOYEES;
    }

    public Employee save(Employee employee)
    {
        EMPLOYEES.add(employee);
        return employee;
    }

    public Employee findById(int id)
    {
        return EMPLOYEES.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public Employee update(Employee employee) {
        var employeeIndex = IntStream.range(0, EMPLOYEES.size())
                .filter(index -> EMPLOYEES.get(index).getId() == employee.getId())
                .findFirst()
                .orElse(-1);//findIndexById(employee.getId());
        if (employeeIndex > -1) {
            EMPLOYEES.set(employeeIndex, employee);
            return employee;
        }
        return null; // or throw an exception if the employee is not found
    }

    public void delete(int id)
    {
        var employee = findById(id);
        if(employee != null)
        {
            EMPLOYEES.remove(employee);
        }
    }
}

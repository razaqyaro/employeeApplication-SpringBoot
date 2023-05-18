package com.razakHussein.employee.employee;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DBEmployeeService implements EmployeeService
{
    private final EmployeeRepository repository;

    public DBEmployeeService(EmployeeRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee)
    {
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees()
    {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id)
    {
        return repository.findById(id);
    }

    @Override
    public Employee update(Employee employee)
    {
        return repository.save(employee);
    }

    @Override
    public void delete(int id)
    {
        repository.deleteById(id);
    }
}

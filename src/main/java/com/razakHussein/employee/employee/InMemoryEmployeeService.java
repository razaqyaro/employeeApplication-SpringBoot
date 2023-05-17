package com.razakHussein.employee.employee;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InMemoryEmployeeService implements EmployeeService
{
    private final InMemoryEmployeeDao dao;

    public InMemoryEmployeeService(InMemoryEmployeeDao daoIn)
    {
        this.dao = daoIn;
    }

    @Override
    public Employee save(Employee employee)
    {
        return dao.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    @Override
    public Employee findById(int Id) {
        return dao.findById(Id);
    }

    @Override
    public Employee update(Employee employee) {
        return dao.update(employee);
    }

    @Override
    public void delete(int Id)
    {
        dao.delete(Id);
    }
}

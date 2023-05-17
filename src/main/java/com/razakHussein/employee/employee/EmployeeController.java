package com.razakHussein.employee.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController
{
    private EmployeeService service;
    public EmployeeController(EmployeeService serviceIn)
    {
        this.service = serviceIn;
    }
    @PostMapping
    public Employee save(@RequestBody Employee employee)
    {
        return service.save(employee);
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") int id)
    {
        return service.findById(id);
    }
    @GetMapping
    public List<Employee> findAllEmployees()
    {
        return service.findAllEmployees();
    }
    @PutMapping
    public Employee update(@RequestBody Employee employee)

    {
        return service.update(employee);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id)
    {
        service.delete(id);
    }
}

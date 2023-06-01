package com.razakHussein.employee.employee.service.implementation;

import com.razakHussein.employee.employee.model.Employee;
import com.razakHussein.employee.employee.repository.EmployeeRepository;
import com.razakHussein.employee.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public Employee update(Employee employee, Integer id) {
        Employee findEmployee = employeeRepository.findById(id).orElseThrow();
        findEmployee.setPhone(employee.getPhone());
        findEmployee.setFirstName(employee.getFirstName());
        findEmployee.setLastName(employee.getLastName());
        findEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(findEmployee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}

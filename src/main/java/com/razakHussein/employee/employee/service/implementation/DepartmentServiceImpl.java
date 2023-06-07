package com.razakHussein.employee.employee.service.implementation;

import com.razakHussein.employee.employee.model.Department;
import com.razakHussein.employee.employee.model.Employee;
import com.razakHussein.employee.employee.repository.DepartmentRepository;
import com.razakHussein.employee.employee.repository.EmployeeRepository;
import com.razakHussein.employee.employee.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService
{
    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    @Override
    public Department update(Department department, Integer id) {
        Department findDepartment = departmentRepository.findById(id).orElseThrow();
        findDepartment.setName(department.getName());
        return departmentRepository.save(findDepartment);
    }

    @Override

    public void delete(int id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department addEmployeeToDepartment(Integer departmentId, Integer employeeId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow();
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        department.getEmployees().add(employee);
        employee.setDepartment(department);
        return departmentRepository.save(department);
    }
}

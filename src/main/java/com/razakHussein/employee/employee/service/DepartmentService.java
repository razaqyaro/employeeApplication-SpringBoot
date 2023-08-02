package com.razakHussein.employee.employee.service;

import com.razakHussein.employee.employee.model.Department;

import java.util.List;

public interface DepartmentService
{
    Department save(Department department);
    List<Department> findAllDepartments();
    Department findById(int id);
    Department update(Department department, Integer id);
    void delete(int id);
   // Department addEmployeeToDepartment(Integer departmentId, Integer employeeId);
}

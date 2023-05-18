package com.razakHussein.employee.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    Employee findById(int id);
    void deleteById(int id);

}

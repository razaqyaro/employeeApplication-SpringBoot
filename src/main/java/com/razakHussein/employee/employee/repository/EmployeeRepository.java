package com.razakHussein.employee.employee.repository;

import com.razakHussein.employee.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{


}

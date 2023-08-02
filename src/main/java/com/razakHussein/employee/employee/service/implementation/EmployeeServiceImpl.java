package com.razakHussein.employee.employee.service.implementation;

import com.razakHussein.employee.employee.DTOmodel.EmployeeDTO;
import com.razakHussein.employee.employee.DTOmodel.EmployeeMapper;
import com.razakHussein.employee.employee.DTOmodel.EmployeeResponse;
import com.razakHussein.employee.employee.model.Department;
import com.razakHussein.employee.employee.model.Employee;
import com.razakHussein.employee.employee.repository.DepartmentRepository;
import com.razakHussein.employee.employee.repository.EmployeeRepository;
import com.razakHussein.employee.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;
    @Override

    public EmployeeDTO save(EmployeeDTO employeeDTO)
    {

        Employee employeeToSave = employeeMapper.fromDTO(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employeeToSave);
        return  employeeMapper.toDTO(savedEmployee);

    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDTO findById(int id) {
        Employee foundEmployee =  employeeRepository.findById(id).orElseThrow();
        EmployeeDTO foundEmployeeDTO = employeeMapper.toDTO(foundEmployee);
        return foundEmployeeDTO;
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO, Integer id)
    {

        Employee foundEmployee = employeeRepository.findById(id).orElseThrow();

        // Update the attributes of the foundEmployee entity with the values from the employeeDTO
        foundEmployee.setPhone(employeeDTO.getPhone());
        foundEmployee.setFirstName(employeeDTO.getFirstName());
        foundEmployee.setLastName(employeeDTO.getLastName());
        foundEmployee.setEmail(employeeDTO.getEmail());
        foundEmployee.setPhone(employeeDTO.getPhone());
        // Save the updated employee entity to the database
        Employee updatedEmployee = employeeRepository.save(foundEmployee);

        // Convert and return the updated employee as DTO
        return employeeMapper.toDTO(updatedEmployee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}

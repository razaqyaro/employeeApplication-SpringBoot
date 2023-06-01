package com.razakHussein.employee.employee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

//dto: study
    // Use dto, firstname and lastname cannot be blank as well as the email.

// Optional<>
    // PATCH and PUT method.
    // User can only be able to update the email
    // Return appropriate status code
    // More on Lomboks
}

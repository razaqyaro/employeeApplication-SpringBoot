package com.razakHussein.employee.employee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "First name is required")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email is required")
    private String email;

    private String phone;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;


//dto: study
    // Use dto, firstname and lastname cannot be blank as well as the email.

// Optional<>
    // PATCH and PUT method.
    // User can only be able to update the email
    // Return appropriate status code
    // More on Lomboks
}

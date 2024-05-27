package org.example.emp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@PersistenceContext
public class Employee {
    @Id
    @Column(name = "emp_id", nullable = false, length = 6)
    private String empId;

    @Column(name = "emp_name", nullable = false, length = 20)
    private String empName;

    @Column(name = "department", length = 4)
    private String department;

    @Enumerated(EnumType.STRING)
    @Column(name = "emp_type", length = 1)
    private empType empType;

    @Column(name = "join_date", length = 10)
    private String joinDate;

    private Long salary;
}

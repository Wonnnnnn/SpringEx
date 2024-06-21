package org.example.empdept_mvc.entity;

import lombok.*;
import jakarta.persistence.*;
import org.apache.logging.log4j.util.Lazy;

@Entity
@Getter
@Setter
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id", nullable=false, length=6)
    private String empId;

    @Column(name="emp_name", nullable=false, length=20)
    private String empName;

    @ManyToOne()
    @JoinColumn(name="dept_id")
    private Department department;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id")
    private Equipment equipment;

    @Enumerated(EnumType.STRING)
    @Column(name="emp_type", length = 1)
    private EmpType empType;

    @Column(name="join_date", length = 10)
    private String joinDate;

    private Long salary;
}

package emp_test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
  @Id
  @Column(name = "emp_id", nullable = false, length = 6)
  private String empId;

  @Column(name = "emp_name", nullable = false, length = 10)
  private String empName;

  @Enumerated(value = EnumType.STRING)
  private EmployeeType emp_type;

  @Column(name="join_date", nullable = false, length = 10)
  private String joinDate;

  @Column(nullable = false)
  private Long salary;

  @ManyToOne
  @JoinColumn(name = "dept_id")
  private Department deptName;
}
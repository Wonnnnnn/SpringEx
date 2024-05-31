package emp_test.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dept_id")
    private int deptId;

    @Column(name="dept_name", nullable = false, length = 10)
    private String deptName;

}

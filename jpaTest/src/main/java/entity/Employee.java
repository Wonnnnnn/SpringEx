package entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="emp_id", nullable = false, length = 6)
    private String empId;

    @Column(name="emp_name", nullable = false, length = 20)
    private String empName;

    @Column(name="department", length = 4)
    private String department;

    @Enumerated(EnumType.STRING)
    @Column(name="emp_type", length = 1)
    private EmpType empType;

    @Column(name="join_date", length = 10)
    private String joinDate;

    private Long salary;

    public Employee() {}

    public Employee(String empId, String empName, String department, EmpType empType, String joinDate, Long salary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.empType = empType;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EmpType getEmpType() {
        return empType;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}

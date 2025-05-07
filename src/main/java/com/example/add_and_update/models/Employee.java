package com.example.add_and_update.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private int employeeId;
    @NotNull
    @NotEmpty
    private String department;
    @NotNull
    @NotEmpty
    private String name;
    //@NotNull
    //@NotEmpty
    // PREGUNTAR A HECTOR POR QUE NO ME TOMA ESTO? SERA POR EL ORDEN?
    @Enumerated(EnumType.STRING)
    private Status status;

    public Employee() {
    }

    public Employee(String department, String name, Status status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}

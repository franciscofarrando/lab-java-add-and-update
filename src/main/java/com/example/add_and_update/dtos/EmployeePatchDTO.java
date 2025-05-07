package com.example.add_and_update.dtos;

import com.example.add_and_update.models.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmployeePatchDTO {
    private String department;

    private String name;

    private Status status;

    public EmployeePatchDTO() {
    }

    public EmployeePatchDTO(String department, String name, Status status) {
        this.department = department;
        this.name = name;
        this.status = status;
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
}

package com.example.add_and_update.repositories;

import com.example.add_and_update.models.Employee;
import com.example.add_and_update.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{

    List<Employee> findEmployeesByStatus(Status status);
    List<Employee> findEmployeesByDepartment(String department);
}

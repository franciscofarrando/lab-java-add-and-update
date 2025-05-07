package com.example.add_and_update.controllers;

import com.example.add_and_update.models.Employee;
import com.example.add_and_update.models.Patient;
import com.example.add_and_update.models.Status;
import com.example.add_and_update.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/id/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getEmployeeById(@PathVariable(name = "employeeId")int id) {
        return employeeRepository.findById(id);
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesByStatus(@PathVariable(name ="status") Status status) {
        return employeeRepository.findEmployeesByStatus(status);
    }
    @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesByDepartment(@PathVariable(name ="department") String department) {
        return employeeRepository.findEmployeesByDepartment(department);
    }

}
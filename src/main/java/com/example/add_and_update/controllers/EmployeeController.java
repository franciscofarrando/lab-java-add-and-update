package com.example.add_and_update.controllers;

import com.example.add_and_update.dtos.EmployeePatchDTO;
import com.example.add_and_update.models.Employee;
import com.example.add_and_update.models.Patient;
import com.example.add_and_update.models.Status;
import com.example.add_and_update.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    // POST & PATCH

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody @Valid Employee employee){
        return employeeRepository.save(employee);
    }

    @PatchMapping("/id/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee changeStatus(@PathVariable int employeeId, @RequestBody EmployeePatchDTO employeePatchDTO){
        Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if(employeePatchDTO.getStatus() != null){
            existingEmployee.setStatus(employeePatchDTO.getStatus());
        }
        if(employeePatchDTO.getDepartment() != null){
            existingEmployee.setDepartment(employeePatchDTO.getDepartment());
        }
        return employeeRepository.save(existingEmployee);
    }


}
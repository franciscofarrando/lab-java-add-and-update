package com.example.add_and_update.controllers;

import com.example.add_and_update.models.Patient;
import com.example.add_and_update.models.Status;
import com.example.add_and_update.repositories.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients(){
       return patientRepository.findAll();
    }

    @GetMapping("/id/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getEmployeeById(@PathVariable(name = "patientId")int id) {
        return patientRepository.findById(id);
    }

   @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findPatientByDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findByAdmittedBy_Status(@PathVariable Status status) {
        return patientRepository.findByAdmittedBy_Status(status);
    }

    // POST PUT & PATCH

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody @Valid Patient patient){
        return patientRepository.save(patient);
        //Preguntar a Hector por que me pone admitted_by : null, SERA QUE HAY QUE PONERLO COMO EL CONSTRUCTOR?
        // PERO AUN ASI NO ME LO TOMA
    }
}

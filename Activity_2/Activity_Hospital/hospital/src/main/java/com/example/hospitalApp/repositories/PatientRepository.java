package com.example.hospitalApp.repositories;

import com.example.hospitalApp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RestController;

@RestResource
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);

}

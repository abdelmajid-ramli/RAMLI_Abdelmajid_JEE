package com.example.demo.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Page<Patient> findByNomContains(String keyword,Pageable pageable);
}

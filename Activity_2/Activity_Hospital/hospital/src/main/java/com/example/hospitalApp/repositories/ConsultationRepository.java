package com.example.hospitalApp.repositories;

import com.example.hospitalApp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}

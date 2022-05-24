package com.example.hospitalApp.repositories;

import com.example.hospitalApp.entities.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medcin,Long> {
    Medcin findByNom(String nom);

}

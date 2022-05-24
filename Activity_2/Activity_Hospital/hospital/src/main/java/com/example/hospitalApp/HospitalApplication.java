package com.example.hospitalApp;

import com.example.hospitalApp.entities.*;
import com.example.hospitalApp.repositories.ConsultationRepository;
import com.example.hospitalApp.repositories.MedecinRepository;
import com.example.hospitalApp.repositories.PatientRepository;
import com.example.hospitalApp.repositories.RendezVousRepository;
import com.example.hospitalApp.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean  
    CommandLineRunner start(IHospitalService iHospitalService,PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository
    , ConsultationRepository consultationRepository)
    {
 return args -> {
     Stream.of("ali","james","ahmed").forEach(name->{
         Patient patient=new Patient();
         patient.setNom(name);
         patient.setDateNaissance(new Date());
         patient.setMalade(false);
         iHospitalService.savePatient(patient);
     });

     Stream.of("samir","hanae","ilham").forEach(name->{
         Medcin medcin=new Medcin();
         medcin.setNom(name);
         medcin.setSpecialite(Math.random()>0.5 ?"Cardio":"Dentiste");
         medcin.setEmail(name+"@gmail.com");
         iHospitalService.saveMedecin(medcin);
     });

     Patient patient=patientRepository.findById(1L).orElse(null);
     Medcin medcin=medecinRepository.findByNom("samir");
     RendezVous rendezVous=new RendezVous();
     rendezVous.setPatient(patient);
     rendezVous.setMedcin(medcin);
     rendezVous.setStatus(StatusRDV.PENDING);
     rendezVous.setDate(new Date());
     rendezVousRepository.save(rendezVous);

     RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
     Consultation consultation=new Consultation();
     consultation.setDAteConsult(rendezVous1.getDate());
     consultation.setRendezVous(rendezVous1);
     consultation.setRapport("Rapport de la Cosultation");
     iHospitalService.saveConsultation(consultation);

    };
    }

}

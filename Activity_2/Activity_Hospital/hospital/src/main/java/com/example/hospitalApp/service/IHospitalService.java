package com.example.hospitalApp.service;

import com.example.hospitalApp.entities.Consultation;
import com.example.hospitalApp.entities.Medcin;
import com.example.hospitalApp.entities.Patient;
import com.example.hospitalApp.entities.RendezVous;


public interface IHospitalService
{
     Patient savePatient(Patient patient);
     Medcin saveMedecin(Medcin medcin);
     RendezVous saveRendezVous (RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);

}

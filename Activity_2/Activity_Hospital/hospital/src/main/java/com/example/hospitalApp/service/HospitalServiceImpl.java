package com.example.hospitalApp.service;

import com.example.hospitalApp.entities.Consultation;
import com.example.hospitalApp.entities.Medcin;
import com.example.hospitalApp.entities.Patient;
import com.example.hospitalApp.entities.RendezVous;
import com.example.hospitalApp.repositories.ConsultationRepository;
import com.example.hospitalApp.repositories.MedecinRepository;
import com.example.hospitalApp.repositories.PatientRepository;
import com.example.hospitalApp.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medcin saveMedecin(Medcin medcin) {
        return medecinRepository.save(medcin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}

package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

@SpringBootApplication
public class PatientMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMvcApplication.class, args); 
		Patient p=new Patient(null,"ali",null,false,80);
		System.out.println("hiii");
		System.out.println(p.getNom());
		System.out.println("test");
	}
	
	@Bean
	public CommandLineRunner cmdRunner(PatientRepository patientRep) {
		return args -> {
			patientRep.save(new Patient(null,"ali",new Date(),false,80));
			patientRep.save(new Patient(null,"ahmed",new Date(),true,70));
			patientRep.save(new Patient(null,"khalid",new Date(),false,85));
			patientRep.save(new Patient(null,"samir",new Date(),false,75));
			
			patientRep.findAll().forEach(p->{
				System.out.println(p.getNom());
			});
		};
	}

}

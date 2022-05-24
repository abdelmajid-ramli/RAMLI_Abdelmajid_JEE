package com.example.demo.web;


import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PatientController {
	private PatientRepository patientRep;
	
    @GetMapping( "/")
    public String home(){
        return "home";
    }
	
	@GetMapping(path="/patients")
	public String patients(Model model,
						   @RequestParam(name = "page",defaultValue = "0") int page,
						   @RequestParam(name = "size",defaultValue = "5") int size,
						   @RequestParam(name = "keyword",defaultValue = "") String keyword) {
		Page<Patient> patientsPage=patientRep.findByNomContains(keyword,PageRequest.of(page, size));
		model.addAttribute("listPatients",patientsPage.getContent());
		model.addAttribute("pages",new int[patientsPage.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("keyword",keyword);
		return "patients";
	}
	
	@GetMapping(path="/formPatient")
	public String formPatient(Model model) {
		
		model.addAttribute("patient",new Patient());
		
		return "formPatient";
	}
	
	@PostMapping(path="/save")
	public String save(Model model,@Valid Patient patient, BindingResult bindingResult,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String keyword) {
		
		if(bindingResult.hasErrors()) {
			return "formPatient";
		}
		patientRep.save(patient);
		
		return "redirect:/patients?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping(path="/editPatient")
	public String editPatient(Model model,Long id,int page,String keyword) {
		Patient patient=patientRep.findById(id).orElse(null);
		if(patient==null) {
		throw new RuntimeException("patient n'existe pas");
		}
		model.addAttribute("patient",patient);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		
		return "editPatient";
	}
	
	@GetMapping(path="/delete")
	public String deletePatient(Model model,@RequestParam(name = "id",defaultValue = "0") Long id,
			   				@RequestParam(name = "page",defaultValue = "0") int page,
			   				@RequestParam(name = "keyword",defaultValue = "")String keyword) {
		patientRep.deleteById(id);
		return "redirect:/patients?page="+page+"&keyword="+keyword;
	}

	
}

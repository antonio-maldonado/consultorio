package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.entity.Cita;
import com.app.repository.ICitaRepository;
import com.app.repository.IConsultorioRepository;
import com.app.repository.IDoctorRepository;
import com.app.service.IServiceCitas;

@Controller
public class CitaController {
    @Autowired
    private IDoctorRepository doctorRepository;
    
    @Autowired
    private IConsultorioRepository consultorioRepository;
    
    @Autowired
    private ICitaRepository citaRepository;
    
    @Autowired
    private IServiceCitas citaService;
	
	@GetMapping("consultar")
	public String consultar(Model model) {
		model.addAttribute("citas", citaRepository.findAll());
		return "consulta";
	}
	
	@GetMapping("alta")
	public String alta(Model model) {
		model.addAttribute("doctores", doctorRepository.findAll());
		model.addAttribute("consultorios", consultorioRepository.findAll());
		return "alta";
	}
	
	@PostMapping("alta")
	public String altaPOST(@ModelAttribute Cita cita,Model model) {
		citaService.createCita(cita);
		model.addAttribute("citas", citaRepository.findAll());
		return "consulta";
	}
}

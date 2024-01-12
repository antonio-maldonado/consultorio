package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.entity.Cita;
import com.app.repository.ICitaRepository;
import com.app.repository.IConsultorioRepository;
import com.app.repository.IDoctorRepository;
import com.app.service.IServiceCitas;
import com.app.validation.FechaValidator;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CitaController {
    @Autowired
    private IDoctorRepository doctorRepository;
    
    @Autowired
    private IConsultorioRepository consultorioRepository;
    
    @Autowired
    private ICitaRepository citaRepository;
    
    @Autowired
    private IServiceCitas citaService;
    
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(fechaValidator);
//    }
	
	@GetMapping("consultar")
	public String consultar(Model model) {
		
		model.addAttribute("citas", citaRepository.findAll());
		model.addAttribute("doctores", doctorRepository.findAll());
		model.addAttribute("consultorios", consultorioRepository.findAll());
		return "consulta";
	}
	
	@GetMapping("alta")
	public String alta(Model model) {
		model.addAttribute("cita",null);
		model.addAttribute("titulo","Dar de alta");
		model.addAttribute("doctores", doctorRepository.findAll());
		model.addAttribute("consultorios", consultorioRepository.findAll());
		return "alta";
	}
	
	@PostMapping("/alta")
	public String altaPOST(@ModelAttribute Cita cita,Model model) {	
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaMinima = fechaActual.plusHours(2);
      
        model.addAttribute("doctores", doctorRepository.findAll());
		model.addAttribute("consultorios", consultorioRepository.findAll());

        if(! cita.getHorarioConsulta().isAfter(fechaMinima)) {
        	model.addAttribute("titulo","Dar de alta");
        	model.addAttribute("cita", cita);
        	model.addAttribute("horarioConsulta","La fecha tiene que ser mayor a 2 horas desde ahora");
        	
        	return "alta";
        }
        
        Cita citaExiste = citaRepository
        		.getCitaByConsulta(cita.getHorarioConsulta(), 
        				cita.getConsultorio().getId());
		
        if(citaExiste!=null) {
        	model.addAttribute("titulo","Dar de alta");
        	model.addAttribute("cita", cita);
        	model.addAttribute("horarioConsulta","Ya hay cita para esa hora y consultorio");
        	return "alta";
        }
        
        citaExiste=null;
        
        LocalDateTime fecha1 = cita.getHorarioConsulta().minusHours(2);
        
        citaExiste = citaRepository.getCitaByPaciente(fecha1, 
        		cita.getHorarioConsulta(), cita.getNombrePaciente());

        if(citaExiste!=null) {
        	model.addAttribute("titulo","Dar de alta");
        	model.addAttribute("cita", cita);
        	model.addAttribute("horarioConsulta","Ya tienes cita para las: "
        	+citaExiste.getHorarioConsulta() + " tiene que haber dos horas de diferencia para la siguiente cita");
        	return "alta";
        }
        
        
        LocalDateTime fechaInicio = cita.getHorarioConsulta().toLocalDate().atStartOfDay();
		LocalDateTime fechaFin = fechaInicio.plusDays(1);
        
        List<Cita> citasDoctor = citaRepository.getCitasByDoctorHoy(
        		fechaInicio, fechaFin,cita.getDoctor().getId() );
        
        if(citasDoctor.size()>=8) {
        	model.addAttribute("titulo","Dar de alta");
        	model.addAttribute("cita", cita);
        	model.addAttribute("doctor","Ese doctor ya tiene ocho citas para ese día y hora, elija otro doctor");
        	return "alta";
        }
        
        Cita citaDoctor = citaRepository.getCitaByDoctor(
        		cita.getHorarioConsulta(), cita.getDoctor().getId());
        
        
        if(citaDoctor!=null) {
        	model.addAttribute("titulo","Dar de alta");
        	model.addAttribute("cita", cita);
        	model.addAttribute("doctor","Ese doctor ya tiene cita para ese día y hora, elija otro doctor");
        	return "alta";
        }
        
        citaService.createCita(cita);
		model.addAttribute("citas", citaRepository.findAll());

		return "consulta";
	}
	
	@PostMapping("filtros-consulta")
	public String consultaPOST(@RequestParam(name="doctor") Long idDoctor,
			@RequestParam(name="consultorio") Long idConsultorio,
			@RequestParam(name="horarioConsulta") LocalDate fecha,Model model) {

		LocalDateTime fechaInicio = fecha.atStartOfDay();
		LocalDateTime fechaFin = fechaInicio.plusDays(1);
		
		model.addAttribute("citas", citaRepository.getCitasByConsulta(fechaInicio, fechaFin, idConsultorio, idDoctor));
		model.addAttribute("doctores", doctorRepository.findAll());
		model.addAttribute("consultorios", consultorioRepository.findAll());
		return "consulta";
	}
	
	@GetMapping("editarConsulta/{id}")
	public String consultaEditar(@PathVariable(name="id") Long id,Model model) {
		Cita cita=citaRepository.findById(id).get();
		
		model.addAttribute("titulo","Editar consulta");
		model.addAttribute("cita", cita);
		return "alta";
	}
	
	@GetMapping("cancelarConsulta/{id}")
	public String consultaEliminar(@PathVariable(name="id") Long id, Model model) {
		//Cita cita=citaRepository.findById(id).get();
		citaRepository.deleteById(id);
		model.addAttribute("citas", citaRepository.findAll());
		return "consulta";
	}
	
}

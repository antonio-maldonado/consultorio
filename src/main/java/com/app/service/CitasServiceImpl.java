package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.entity.Cita;
import com.app.repository.ICitaRepository;


@Service
public class CitasServiceImpl implements IServiceCitas{
	@Autowired 
	ICitaRepository citaRepository;

	@Override
	public Cita createCita(Cita cita) {
	
		return citaRepository.save(cita);
	}

	@Override
	public Cita getCitaById(Long id) {
		return citaRepository.findById(id).get();
	}

	@Override
	public List<Cita> getAllCitas() {
		return citaRepository.findAll();
	}

	@Override
	public Cita updateCitas(Cita category, Long id) {

		return null;
	}

	@Override
	public void deleteCita(Long id) {
		
		
	}
	
	@Override
	public List<Cita> getCitasByHorarioConsulta(LocalDateTime fecha){
		return citaRepository.getCitasByHorarioConsulta(fecha);
	}

	@Override
	public List<Cita> getCitasByConsulta(LocalDateTime fecha,LocalDateTime fecha2, Long idConsultorio, Long idDoctor) {
		return citaRepository.getCitasByConsulta(fecha, fecha2,idConsultorio, idDoctor);
	}
	
	@Override
	public Cita getCitaByConsulta(LocalDateTime fecha,Long idConsultorio) {
		return citaRepository.getCitaByConsulta(fecha, idConsultorio);
	}
	
	@Override
	public List<Cita> getCitasByDoctorHoy(LocalDateTime fecha,LocalDateTime fecha2,
			Long idDoctor){
		return citaRepository.getCitasByDoctorHoy(fecha, fecha2,idDoctor);
	}
	
	@Override
	public Cita getCitaByPaciente(LocalDateTime fecha,LocalDateTime fecha2,String nombre){
		return citaRepository.getCitaByPaciente(fecha, fecha2, nombre);
	}
	
	@Override
	public Cita getCitaByDoctor(LocalDateTime fecha,Long idDoctor) {
		return citaRepository.getCitaByDoctor(fecha, idDoctor);
	}

}

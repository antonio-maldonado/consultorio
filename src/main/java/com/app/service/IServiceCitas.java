package com.app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.app.entity.Cita;

public interface IServiceCitas {
	Cita createCita(Cita category);

	Cita getCitaById(Long id);

	List<Cita> getAllCitas();

	Cita updateCitas(Cita category, Long id);

	void deleteCita(Long id);
	
	List<Cita> getCitasByHorarioConsulta(LocalDateTime fecha);	
	
	List<Cita> getCitasByConsulta(LocalDateTime fecha,LocalDateTime fecha2,
			Long idConsultorio,Long idDoctor);
	
	Cita getCitaByConsulta(LocalDateTime fecha,Long idConsultorio);
	
	List<Cita> getCitasByDoctorHoy(LocalDateTime fecha,LocalDateTime fecha2,
			Long idDoctor);
	
	Cita getCitaByPaciente(LocalDateTime fecha,LocalDateTime fecha2,String nombre);

	Cita getCitaByDoctor(LocalDateTime fecha,Long idDoctor);

}

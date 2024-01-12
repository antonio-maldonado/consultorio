package com.app.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Cita;

public interface ICitaRepository extends JpaRepository<Cita, Long>{
	Optional<Cita> findById(Long id);
	
	@Query("select c from Cita c where horarioConsulta >= ?1")
	List<Cita> getCitasByHorarioConsulta(LocalDateTime fecha);
	
	@Query("select c from Cita c where horarioConsulta BETWEEN ?1 AND ?2 AND consultorio.id = ?3 AND doctor.id = ?4")
	List<Cita> getCitasByConsulta(LocalDateTime fecha,LocalDateTime fecha2,
			Long idConsultorio,Long idDoctor);
	
	@Query("select c from Cita c where horarioConsulta BETWEEN ?1 AND ?2 AND doctor.id = ?3")
	List<Cita> getCitasByDoctorHoy(LocalDateTime fecha,LocalDateTime fecha2,
			Long idDoctor);
	
	@Query("select c from Cita c where horarioConsulta = ?1 AND consultorio.id = ?2")
	Cita getCitaByConsulta(LocalDateTime fecha,Long idConsultorio);
	
	@Query("select c from Cita c where horarioConsulta BETWEEN ?1 AND ?2 AND nombrePaciente = ?3")
	Cita getCitaByPaciente(LocalDateTime fecha,LocalDateTime fecha2,String nombre);
	
	@Query("select c from Cita c where horarioConsulta = ?1 AND doctor.id = ?2")
	Cita getCitaByDoctor(LocalDateTime fecha,Long idDoctor);
	
}

package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Cita;
import com.app.entity.Consultorio;

public interface ICitaRepository extends JpaRepository<Cita, Long>{
	Optional<Cita> findById(Long id);
}

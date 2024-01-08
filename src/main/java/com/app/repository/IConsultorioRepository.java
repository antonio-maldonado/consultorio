package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Consultorio;


public interface IConsultorioRepository extends JpaRepository<Consultorio, Long>{
	Optional<Consultorio> findById(Long id);
}

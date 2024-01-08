package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Long>{
	Optional<Doctor> findById(Long id);
}

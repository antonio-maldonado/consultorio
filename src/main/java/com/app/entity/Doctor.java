package com.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctores")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private Long id;
	
	@Column(name = "nombre", nullable = false, length = 50, unique = false)
	private String nombre;
	
	@Column(name = "apellido_paterno", nullable = false, length = 50, unique = false)
	private String apellidoPaterno;
	
	@Column(name = "apellido_materno", nullable = false, length = 50, unique = false)
	private String apellidoMaterno;
	
	@Column(name = "especialidad", nullable = false, length = 50, unique = false)
	private String especialidad;
}

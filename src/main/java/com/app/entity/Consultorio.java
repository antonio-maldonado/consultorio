package com.app.entity;

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
@Table(name = "consultorios")
public class Consultorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consultorio_id")
	private Long id;

	@Column(name = "numero_consultorio", nullable = false, unique = false)
	private int numeroConsultorio;
	
	@Column(name = "piso", nullable = false, length = 50,unique = false)
	private String piso;
	
}

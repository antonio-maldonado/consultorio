package com.app.entity;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "citas")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cita_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idConsultorio")
    private Consultorio consultorio;

    @ManyToOne
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;

    private LocalDateTime horarioConsulta;
    
    @Column(name = "nombre", nullable = false, length = 100, unique = false)
    private String nombrePaciente;

}	

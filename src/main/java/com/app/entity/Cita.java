package com.app.entity;



import java.time.LocalDateTime;

import com.app.validation.FechaValida;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
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

    //@FechaValida(message = "La fecha debe ser al menos dos horas en adelante")
    //@Null(message = "La edad debe ser un número positivo")
    private LocalDateTime horarioConsulta;
    
    @Column(name = "nombre", nullable = false, length = 100, unique = false)
    private String nombrePaciente;

}	

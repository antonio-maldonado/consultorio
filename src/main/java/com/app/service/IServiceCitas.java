package com.app.service;

import java.util.List;

import com.app.entity.Cita;

public interface IServiceCitas {
	Cita createCita(Cita category);

	Cita getCitaById(Long id);

	List<Cita> getAllCitas();

	Cita updateCitas(Cita category, Long id);

	void deleteCita(Long id);
}

package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.entity.Cita;
import com.app.repository.ICitaRepository;


@Service
public class CitasServiceImpl implements IServiceCitas{
	@Autowired 
	ICitaRepository citaRepository;

	@Override
	public Cita createCita(Cita cita) {
	
		return citaRepository.save(cita);
	}

	@Override
	public Cita getCitaById(Long id) {
		return citaRepository.findById(id).get();
	}

	@Override
	public List<Cita> getAllCitas() {
		
		return citaRepository.findAll();
	}

	@Override
	public Cita updateCitas(Cita category, Long id) {

		return null;
	}

	@Override
	public void deleteCita(Long id) {
		
		
	}
}

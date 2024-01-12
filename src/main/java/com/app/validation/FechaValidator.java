package com.app.validation;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.entity.Cita;

@Component
public class FechaValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Cita.class.equals(clazz);
	}

	@Override
	public void validate(Object cita, Errors errors) {

        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaMinima = fechaActual.plusHours(2);

        if(((Cita) cita).getHorarioConsulta().isAfter(fechaMinima)) {
        	 errors.rejectValue("horarioConsulta", "error.codigo", "Mensaje de error");
        }
		
	}

}

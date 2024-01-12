package com.app.validation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.repository.ICitaRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FechaExistenteValidator implements ConstraintValidator<FechaValida, LocalDateTime>  {
    @Autowired
    private ICitaRepository citaRepository;
    
	@Override
	public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
		
		return false;
	}

}

package com.app.validation;

import java.time.LocalDateTime;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FechaValidaValidator implements ConstraintValidator<FechaValida, LocalDateTime> {

    @Override
    public boolean isValid(LocalDateTime fechaIngresada, ConstraintValidatorContext context) {

        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaMinima = fechaActual.plusHours(2);

        return fechaIngresada.isAfter(fechaMinima);
    }
}
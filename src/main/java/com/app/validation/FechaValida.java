package com.app.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//@Documented
@Constraint(validatedBy = FechaValidaValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface FechaValida {
    String message() default "La fecha debe ser al menos dos horas en adelante";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
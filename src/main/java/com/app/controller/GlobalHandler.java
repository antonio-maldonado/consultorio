package com.app.controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
//	 @ExceptionHandler(MethodArgumentNotValidException.class)
//	    public String handleValidationException(MethodArgumentNotValidException ex, 
//	    		Model model, Errors errors) {
//	        // Aquí puedes agregar la lógica para redirigir a otra vista específica
//	        model.addAttribute("error", "La fecha ingresada no es válida");
//       	 	errors.rejectValue("horarioConsulta", "error.codigo", "Mensaje de error");
//model.addAttribute(errors);
//	        return "alta";  // Reemplaza "errorPage" con el nombre de tu vista de error
//	    }

}

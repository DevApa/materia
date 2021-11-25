package com.core.materia.utils.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	private ErrorInfo constraintViolationException(HttpServletRequest request, ConstraintViolationException ex) {
		return new ErrorInfo(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorInfo methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
		return new ErrorInfo(ex.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
	}
}

package org.employee.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public String nosuchElementException(NoSuchElementException e) {
		System.out.println(e.getMessage());
		return e.getMessage();
		
	}
	

}

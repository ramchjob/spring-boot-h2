package com.sq.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sq.learn.model.ErrorDetails;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	 @ExceptionHandler({Exception.class})
	    public ResponseEntity<Object> handleException(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(buildErrorResponse(e));
	 }

	private Object buildErrorResponse(Exception e) {
		ErrorDetails error = new ErrorDetails();
		error.setErrorCode(1000);
		error.setErrorMessage(e.getMessage());
		return error;
	}

}

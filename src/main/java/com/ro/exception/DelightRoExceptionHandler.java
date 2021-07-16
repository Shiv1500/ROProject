package com.ro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DelightRoExceptionHandler {

//	@ExceptionHandler(DelightRoException.class)
//	public ResponseEntity<Object> handleCustomeException(DelightRoException delightRoException) {
//		ErrorResponse errorResponse = new ErrorResponse();
//		errorResponse.setCode(HttpStatus.NOT_FOUND.value()+"");
//		errorResponse.setMessage(delightRoException.getMessage());
//		return new ResponseEntity<Object>(errorResponse,HttpStatus.NOT_FOUND);
//	}
//	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code =HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorResponse> ExceptionHandler(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
		errorResponse.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.name());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

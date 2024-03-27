package com.shubham.social.media.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetail> userExcetionHandler(UserException ue, WebRequest req) {
		
		ErrorDetail error = new ErrorDetail(ue.getMessage(),req.getDescription(false),LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetail>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PostException.class)
	public ResponseEntity<ErrorDetail> postExcetionHandler(UserException ue, WebRequest req) {
		
		ErrorDetail error = new ErrorDetail(ue.getMessage(),req.getDescription(false),LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetail>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> otherExcetionHandler(Exception ue, WebRequest req) {
		
		ErrorDetail error = new ErrorDetail(ue.getMessage(),req.getDescription(false),LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetail>(error,HttpStatus.BAD_REQUEST);
	}
	
	

}

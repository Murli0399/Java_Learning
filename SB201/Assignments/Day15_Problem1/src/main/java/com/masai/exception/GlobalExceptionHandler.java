package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<MyErrorDetails> handleProductNotFoundException(ProductNotFound ex, WebRequest rq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(rq.getDescription(false));
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

}

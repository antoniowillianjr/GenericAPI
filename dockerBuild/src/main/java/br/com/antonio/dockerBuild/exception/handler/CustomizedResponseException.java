package br.com.antonio.dockerBuild.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.antonio.dockerBuild.exception.ArrayTooLargeResponse;
import br.com.antonio.dockerBuild.exception.ExceptionResponse;
import br.com.antonio.dockerBuild.exception.FieldNotFoundResponse;

@RestController
@ControllerAdvice
public class CustomizedResponseException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(FieldNotFoundResponse.class)
	public final ResponseEntity<?> fieldNotFound(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ArrayTooLargeResponse.class)
	public final ResponseEntity<?> arrayTooLargeResponse(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), HttpStatus.PAYLOAD_TOO_LARGE.value(), HttpStatus.PAYLOAD_TOO_LARGE.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.PAYLOAD_TOO_LARGE);
	}
}

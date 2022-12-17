package org.ib.was.docs.controllers.ex;

import java.io.FileNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		// String error = "Malformed JSON request";
		return buildResponseEntity(new ResponseError(HttpStatus.BAD_REQUEST, ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ResponseError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	// other exception handlers below
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {

		ResponseError err = new ResponseError(HttpStatus.NOT_FOUND);
		err.setMessage(ex.getMessage());
		
		return buildResponseEntity(err);
	}

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {

		ResponseError err = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR);
		err.setMessage(ex.getMessage());
		
		return buildResponseEntity(err);
	}

	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException ex) {

		//List<String> details = new ArrayList<String>();
		//details.add(exc.getMessage());
		//ResponseError err = new ResponseError(LocalDateTime.now(), "File Not Found", details);
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		ResponseError err = new ResponseError(HttpStatus.NOT_FOUND);
		err.setMessage(ex.getMessage());
		
		return buildResponseEntity(err);
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<Object> handleMaxSizeException(MaxUploadSizeExceededException ex) {

		//List<String> details = new ArrayList<String>();
		//details.add(exc.getMessage());
		//ResponseError err = new ResponseError(LocalDateTime.now(), "File Size Exceeded", details);
		//return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(err);
		ResponseError err = new ResponseError(HttpStatus.EXPECTATION_FAILED);
		err.setMessage(ex.getMessage());
		
		return buildResponseEntity(err);
	}

}

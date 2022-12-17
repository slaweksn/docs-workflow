package org.ib.was.docs.controllers.ex;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder(value = {"timestamp","status","message",""})
@Data
public class ResponseError {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private List<ApiSubError> subErrors;

	private ResponseError() {
		timestamp = LocalDateTime.now();
	}

	ResponseError(HttpStatus status) {
		this();
		this.status = status;
	}

	ResponseError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message =  ex.getMessage();
		this.debugMessage = ex.getLocalizedMessage();
	}
	/*-
	ApiError(HttpStatus status, Throwable ex, String message) {
		this();
		this.status = status;
		this.message = message;
		//this.debugMessage = ex.getLocalizedMessage();
	}
	*/
}

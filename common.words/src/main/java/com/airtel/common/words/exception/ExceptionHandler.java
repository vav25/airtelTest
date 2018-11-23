package com.airtel.common.words.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleDataNotFoundException(DataNotFoundException exception) {

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(HttpStatus.NOT_FOUND.name());
		errorDetails.setErrorMessage(exception.getMessage());

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(RequestNotValidException.class)
	public ResponseEntity<ErrorDetails> handleRequestNotValidException(RequestNotValidException exception) {

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(HttpStatus.BAD_REQUEST.name());
		errorDetails.setErrorMessage(exception.getMessage());

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorDetails> handleServiceException(ServiceException exception) {

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
		errorDetails.setErrorMessage(exception.getMessage());

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Throwable.class)
	public ResponseEntity<ErrorDetails> handleThrowable(Throwable exception) {

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
		errorDetails.setErrorMessage(exception.getMessage());

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

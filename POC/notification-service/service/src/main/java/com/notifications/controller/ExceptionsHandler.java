package com.notifications.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@ControllerAdvice
public class ExceptionsHandler {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public String handleBeanValidationError(MethodArgumentNotValidException ex) {

		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		StringBuilder sbErrorMsg = new StringBuilder();
		String delim = "; ";
		
		for (ObjectError error : allErrors) {
			sbErrorMsg.append(error.getObjectName());
			if(error instanceof FieldError){
				FieldError fieldError = (FieldError) error;
				sbErrorMsg.append("." + fieldError.getField());
			}
			sbErrorMsg.append(" "+ error.getDefaultMessage());
			sbErrorMsg.append(delim);
		}
		
		return  sbErrorMsg.toString();
	}


	@ExceptionHandler({ HttpMessageNotReadableException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleSpringMessageUnreadableExceptions(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		LOGGER.error(ex.getMessage(), ex);
		return ex.getMessage();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String handleException(Exception ex) {
		LOGGER.error(ex.getMessage(), ex);
		return ex.getMessage();
	}

}
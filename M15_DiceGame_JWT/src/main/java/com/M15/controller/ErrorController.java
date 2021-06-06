package com.M15.controller;

import java.security.AccessControlException;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ErrorController extends DefaultResponseErrorHandler {

	@ExceptionHandler({AccessControlException.class, AccessDeniedException.class })
	@ResponseBody
	public ResponseEntity<StringDto> requestForbidden() {
		return new ResponseEntity<>(StringDto.stringToJson("Sorry, you don't have permissions for this section."), HttpStatus.FORBIDDEN);

	}

	@ExceptionHandler({ ServletException.class, NoSuchElementException.class })
	@ResponseBody
	public ResponseEntity<StringDto> requestNotFound() {
		return new ResponseEntity<>(StringDto.stringToJson("Sorry, ID not found."), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class })
	@ResponseBody
	public ResponseEntity<StringDto> invalidRequest() {
		return new ResponseEntity<>(
				StringDto.stringToJson("Please check ID or other paramethers."),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class, NullPointerException.class })
	@ResponseBody
	public ResponseEntity<StringDto> cantFound() {
		return new ResponseEntity<>(StringDto.stringToJson("Sorry, player not found."),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
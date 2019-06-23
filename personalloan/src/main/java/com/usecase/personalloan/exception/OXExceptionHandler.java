package com.usecase.personalloan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.usecase.personalloan.dto.ResponseDto;

@ControllerAdvice
public class OXExceptionHandler {

	@ExceptionHandler(OXBankingException.class)
	public ResponseEntity<ResponseDto> handleException(Exception e){
		return new ResponseEntity<ResponseDto>(new ResponseDto(e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
	}
}

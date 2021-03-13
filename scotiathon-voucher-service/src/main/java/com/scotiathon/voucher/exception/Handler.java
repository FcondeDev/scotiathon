package com.scotiathon.voucher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.scotiathon.voucher.dto.ApiErrorDTO;
import com.scotiathon.voucher.error.ErrorEnum;

import lombok.extern.java.Log;

@RestControllerAdvice
@Log
public class Handler {

	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiErrorDTO> handleException(MethodArgumentNotValidException exception) {

		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {

			log.info(String.format("--- WRONG PARAMETER : %s ---", fieldError.getField()));

		}
		return new ResponseEntity<>(new ApiErrorDTO(ErrorEnum.INVALID_PARAMETER.code, ErrorEnum.INVALID_PARAMETER.title,
				ErrorEnum.INVALID_PARAMETER.description), HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<ApiErrorDTO> handleException(CustomException exception) {
		log.info(String.format("---  CUSTOM EXCEPTION TRIGGERED : %s ---", exception.getMessage()));
		return new ResponseEntity<>(new ApiErrorDTO(exception.getErrorEnum().code, exception.getErrorEnum().title,
				exception.getErrorEnum().description), HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ApiErrorDTO> handleException(NotFoundException exception) {
		log.info("--- RESOURCE NOT FOUND -----");
		return new ResponseEntity<>(new ApiErrorDTO(ErrorEnum.NOT_FOUND_EXCEPTION.code,
				ErrorEnum.NOT_FOUND_EXCEPTION.title, ErrorEnum.NOT_FOUND_EXCEPTION.description), HttpStatus.NOT_FOUND);
	}

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiErrorDTO> handleException(Exception exception) {
		log.info(String.format("--- SOMETHING UNEXPECTED HAPPENED  : %s ---", exception.getMessage()));
		return new ResponseEntity<>(new ApiErrorDTO(ErrorEnum.DEFAULT_EXCEPTION.code, ErrorEnum.DEFAULT_EXCEPTION.title,
				ErrorEnum.DEFAULT_EXCEPTION.description), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseBody
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<ApiErrorDTO> handleException(MissingServletRequestParameterException exception) {
		log.info(String.format("--- MISSING PARAMETER : %s ---", exception.getParameterName()));
		return new ResponseEntity<>(new ApiErrorDTO(ErrorEnum.PARAMETER_REQUIRED_NOT_FOUND.code,
				ErrorEnum.PARAMETER_REQUIRED_NOT_FOUND.title, ErrorEnum.PARAMETER_REQUIRED_NOT_FOUND.description),
				HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ApiErrorDTO> handleException(HttpMediaTypeNotSupportedException exception) {
		log.info(String.format("--- JSON HAS INVALID PARAMETERS : %s ---", exception.getMessage()));
		return new ResponseEntity<>(new ApiErrorDTO(ErrorEnum.PARAMETER_REQUIRED_NOT_FOUND.code,
				ErrorEnum.PARAMETER_REQUIRED_NOT_FOUND.title, ErrorEnum.PARAMETER_REQUIRED_NOT_FOUND.description),
				HttpStatus.BAD_REQUEST);
	}

}

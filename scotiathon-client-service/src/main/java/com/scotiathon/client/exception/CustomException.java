package com.scotiathon.client.exception;

import org.springframework.http.HttpStatus;

import com.scotiathon.client.error.ErrorEnum;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -6628372263603848109L;
	private final HttpStatus httpStatus;
	private final ErrorEnum errorEnum;

	public CustomException(ErrorEnum errorEnum, HttpStatus httpStatus) {
		this.errorEnum = errorEnum;
		this.httpStatus = httpStatus;

	}

}

package com.scotiathon.client.error;

public enum ErrorEnum {

	NOT_FOUND_EXCEPTION(1, "NOT FOUND", "The resource could not be found"),
	INVALID_PARAMETER(2, "INVALID PARAMETER", "Some of the input parameters are invalid"),
	DEFAULT_EXCEPTION(3, "UPSS", "Something happened, try later"),
	PARAMETER_REQUIRED_NOT_FOUND(4, "REQUIRED PARAMETER NOT FOUND", "Input data does not contains a mandatory field"),
	USER_BLOCKED(5, "USER BLOCKED", "You have been blocked, please contact you administrator"),
	WRONG_PASSWORD_OR_USER(5, "USER OR PASSWORD ARE WRONG", "User not allowed to log in"),
	TOKEN_UNAVAILABLE(5, "TOKEN IS NOT AVAILABLE", "jwt token is not available now"),
	ACCOUNT_IS_GONNA_BE_BLOCKED(5, "LAST ATTEMPT TO LOG IN", "Last attemps to get you account blocked");

	public final int code;
	public final String title;
	public final String description;

	ErrorEnum(int code, String title, String description) {
		this.code = code;
		this.title = title;
		this.description = description;
	}

}

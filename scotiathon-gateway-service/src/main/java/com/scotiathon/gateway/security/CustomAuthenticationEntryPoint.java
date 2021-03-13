package com.scotiathon.gateway.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scotiathon.gateway.dto.ApiErrorDTO;

import lombok.extern.java.Log;

@Log
public class CustomAuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

	@Autowired
	private ObjectMapper objectMapper;

	private static final String ERROR_DESCRIPTION = "ERROR SECURITY FILTER : %s";
	private static final String ERROR_TITLE = "SECURITY ERROR";
	private static final int ERORR_CODE = 1;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		log.severe(String.format(" !! UNAUTHORIZED EXCEPTION !! : %s", authException.getMessage()));
		if (authException.getClass().equals(InsufficientAuthenticationException.class)) {
			createResponse(response, 401, "Access token expired or invalid");
		} else {
			createResponse(response, 401, authException.getMessage());
		}
	}

	private void createResponse(HttpServletResponse response, int statusCode, String errorMessage) {

		response.setContentType("application/json");
		response.setStatus(statusCode);
		ApiErrorDTO apiErrorDTO = new ApiErrorDTO(ERORR_CODE, ERROR_TITLE,
				String.format(ERROR_DESCRIPTION, errorMessage));

		createErrorResponse(apiErrorDTO, response);
	}

	private void createErrorResponse(ApiErrorDTO apiErrorDTO, HttpServletResponse response) {
		try {
			response.getWriter().write(objectMapper.writeValueAsString(apiErrorDTO));
		} catch (IOException e) {
			log.severe(String.format("Error setting a new body : %s", e.getMessage()));
		}
	}

}

package com.scotiathon.auth.security.event;

import java.util.logging.Level;

import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		log.info(String.format("Success  Login, email: %s", user.getUsername()));
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		log.log(Level.SEVERE, "Login failed", exception.getMessage());
	}

}

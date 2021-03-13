package com.scotiathon.auth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scotiathon.auth.dto.ClientDTO;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	ClientFeignClient clientFeignClient;

	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			ClientDTO client = clientFeignClient.getClientByScotiaId(username).getBody().getData();

			List<GrantedAuthority> authorities = client.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

			return new User(client.getEmail(), client.getPassword(), client.isEnabled(), true, true, true, authorities);
		} catch (Exception e) {
			throw new UsernameNotFoundException("Error while getting user details");
		}
	}

}

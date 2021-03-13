package com.scotiathon.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.scotiathon.client.dto.AuthResponseDTO;

@FeignClient("${eureka.scotiathon.oauth.service}")
public interface OauthFeignClient {

	@PostMapping("oauth/token")
	public AuthResponseDTO getToken(@RequestBody MultiValueMap<String, Object> credentials,
			@RequestHeader("Authorization") String basicAuth);

}

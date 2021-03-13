package com.scotiathon.auth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scotiathon.auth.dto.ClientDTO;
import com.scotiathon.auth.dto.JsonDTO;

@FeignClient("${eureka.scotiathon.client.service}")
public interface ClientFeignClient {

	@GetMapping("clients/details")
	public ResponseEntity<JsonDTO<ClientDTO>> getClientByScotiaId(@RequestParam("scotiaId") String scotiaId);
}

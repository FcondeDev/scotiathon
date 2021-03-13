package com.scotiathon.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scotiathon.client.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByScotiaId(String scotiaId);

}

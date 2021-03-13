package com.scotiathon.voucher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scotiathon.voucher.entity.EscalatedTo;

public interface EscalatedToRepository extends JpaRepository<EscalatedTo, Long> {

}

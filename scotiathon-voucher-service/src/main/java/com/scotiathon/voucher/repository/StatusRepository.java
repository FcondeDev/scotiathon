package com.scotiathon.voucher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scotiathon.voucher.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}

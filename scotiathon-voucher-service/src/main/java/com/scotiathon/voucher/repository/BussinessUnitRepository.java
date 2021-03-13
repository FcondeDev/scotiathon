package com.scotiathon.voucher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scotiathon.voucher.entity.BusinessUnit;

public interface BussinessUnitRepository extends JpaRepository<BusinessUnit, Long> {

}

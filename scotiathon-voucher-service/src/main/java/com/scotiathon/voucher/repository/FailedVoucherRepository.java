package com.scotiathon.voucher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scotiathon.voucher.entity.FailedVoucher;

@Repository
public interface FailedVoucherRepository extends JpaRepository<FailedVoucher, Long> {

}

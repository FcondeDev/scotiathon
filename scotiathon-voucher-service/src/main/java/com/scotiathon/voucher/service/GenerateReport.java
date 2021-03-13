package com.scotiathon.voucher.service;

import java.util.List;

import com.scotiathon.voucher.entity.FailedVoucher;

public interface GenerateReport {

	void generateFailureReport(List<FailedVoucher> failedVouchers);

}

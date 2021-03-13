package com.scotiathon.voucher.entity;

import org.springframework.beans.factory.annotation.Value;

public interface GetBuAndVoucherId {

	@Value("#{target.bu + target.voucher_id}")
	String getBuPlusVoucherId();

}

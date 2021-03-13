package com.scotiathon.voucher.validation;

public enum VoucherSource {

	ONLINE("Online"), PAYMENT_REQUEST("Payment Request");

	private String value;

	VoucherSource(String value) {
		this.value = value;
	}

	public static boolean isPresent(String input) {
		for (VoucherSource b : VoucherSource.values()) {
			if (String.valueOf(b.value).equals(input)) {
				return true;
			}
		}
		return false;
	}

}

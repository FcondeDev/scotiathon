package com.scotiathon.voucher.validation;

public enum EntryStatus {

	RECYCLE("Recycle"), POSTABLE("Postable");

	private String value;

	EntryStatus(String value) {
		this.value = value;
	}

	public static boolean isPresent(String input) {
		for (EntryStatus b : EntryStatus.values()) {
			if (String.valueOf(b.value).equals(input)) {
				return true;
			}
		}
		return false;
	}

}

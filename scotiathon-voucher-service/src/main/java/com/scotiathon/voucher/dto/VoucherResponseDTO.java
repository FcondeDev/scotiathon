package com.scotiathon.voucher.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class VoucherResponseDTO {

	private Boolean csvWasReceived;
	private Boolean assignmentCompleted;

	public VoucherResponseDTO(boolean csvWasReceived) {
		this.csvWasReceived = csvWasReceived;
	}

}

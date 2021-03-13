package com.scotiathon.voucher.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReasonEscalationDTO {

	private Long id;
	private String description;

	public ReasonEscalationDTO(Long id) {
		this.id = id;
	}

}

package com.scotiathon.voucher.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoucherDTO {

	private Long id;
	private String bu;
	private String voucherId;
	private String linesEntered;
	private String voucherSource;
	private String voucherCreatedBy;
	private String voucherCreatedOn;
	private String postStatus;
	private String entryStatus;
	private String supplierId;
	private String shortSupplierName;
	private String supplierName;
	private String invoiceNumber;
	private String invoiceDate;
	private String invoiceReceived;
	private String voucherAmount;
	private String voucherCurrency;
	private String approvalStatus;
	private String age;

}

package com.vodafone.problems.voucher.models;

import lombok.Data;

@Data
public class Voucher extends PersonalInfo {
	private String voucherNumber;
	private double voucherValue;
	private String currency;
	
	public Voucher(String voucherNumber, double voucherValue, String currency, String firstName, String lastName) {
		this.voucherNumber = voucherNumber;
		this.voucherValue = voucherValue;
		this.currency = currency;
		super.setFirstName(firstName);
		super.setLastName(lastName);
	}
}

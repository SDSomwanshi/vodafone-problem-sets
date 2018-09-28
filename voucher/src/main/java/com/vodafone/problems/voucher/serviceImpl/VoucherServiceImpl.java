package com.vodafone.problems.voucher.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vodafone.problems.voucher.models.Voucher;
import com.vodafone.problems.voucher.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService {
	
	private static List<Voucher> vouchers = populateVouchers();
	
	@Override
	public List<Voucher> getVouchers() {
		
		return vouchers;
	}

	private static List<Voucher> populateVouchers() {
		
		List<Voucher> vouchers = new ArrayList<>();
		
		vouchers.add(new Voucher("V2378578346", 1200, "INR", "Drew", "Barrymore"));
		vouchers.add(new Voucher("V183240062", 5, "USD", "Johnny", "Depp"));
		vouchers.add(new Voucher("V45708293", 500, "INR", "Drew", "Barrymore"));
		vouchers.add(new Voucher("V1106", 60, "INR", "Brad", "Pitt"));
		return vouchers;
	}
	
}

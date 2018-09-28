package com.vodafone.problems.credits.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vodafone.problems.credits.models.Credit;
import com.vodafone.problems.credits.service.CreditService;

@Service
public class CreditSeviceImpl implements CreditService {
	
	@Override
	public List<Credit> getCredits() {
		
		return populateCredits();
	}

	private List<Credit> populateCredits() {
		
		List<Credit> credit = new ArrayList<>();
		
		credit.add(new Credit("C072341", 100, "Drew", "Barrymore"));
		credit.add(new Credit("C3475634", 50, "Johnny", "Depp"));
		credit.add(new Credit("C34857", 10, "Drew", "Barrymore"));
		return credit;
	}
}

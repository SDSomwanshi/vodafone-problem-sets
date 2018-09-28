package com.vodafone.problems.rewards.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.vodafone.problems.rewards.models.Credit;
import com.vodafone.problems.rewards.models.Reward;
import com.vodafone.problems.rewards.models.Voucher;
import com.vodafone.problems.rewards.response.ServiceResponse;
import com.vodafone.problems.rewards.service.CreditService;
import com.vodafone.problems.rewards.service.RewardService;
import com.vodafone.problems.rewards.service.VoucherService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RewardServiceImpl implements RewardService {
	
	private final RestTemplate restTemplate;
	
	@Value("${app.service-endpoints.vouchers-service}")
	private String voucherEndpoint;
	
	@Value("${app.service-endpoints.credit-service}")
	private String creditEndpoint;
	
	@Override
	public List<Reward> getRewards() {
		ResponseEntity<List<Voucher>> voucherList = null;
		ResponseEntity<List<Credit>> creditList = null;
		List<Reward> rewardList = null;
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        try {
        	voucherList = restTemplate.exchange(voucherEndpoint, HttpMethod.GET, null, new ParameterizedTypeReference<List<Voucher>>(){});
        	creditList = restTemplate.exchange(creditEndpoint, HttpMethod.GET, null, new ParameterizedTypeReference<List<Credit>>(){});
        	rewardList = getRewardsByPerson(voucherList.getBody(),creditList.getBody());
        } catch (Exception ex) {
            log.error("An error has occurred while retrieving details through REST API call." + ex);
        }
		
		return rewardList;
	}
	
	public List<Reward> getRewardsByPerson(List<Voucher> vouchers, List<Credit> credits) {
		Map<String, Reward>	rewardMap = new HashMap<>();
		vouchers.forEach(voucher -> {
			String key = voucher.getFirstName()+"_"+voucher.getLastName();
			Reward r = rewardMap.get(key);
			if(r==null) {
				r = new Reward();
				r.setFirstName(voucher.getFirstName());
				r.setLastName(voucher.getLastName());
				rewardMap.put(key, r);
			}
			r.getVoucher().add(voucher.getVoucherNumber());
		});
		
		credits.forEach(credit -> {
			String key = credit.getFirstName()+"_"+credit.getLastName();
			Reward r = rewardMap.get(key);
			if(r==null) {
				r = new Reward();
				r.setFirstName(credit.getFirstName());
				r.setLastName(credit.getLastName());
				rewardMap.put(key, r);
			}
			r.getCredit().add(credit.getCreditId());
		});
		
		return new ArrayList<>(rewardMap.values());
		
	}
	
}

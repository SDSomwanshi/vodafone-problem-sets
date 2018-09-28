package com.vodafone.problems.rewards.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Reward extends PersonalInfo {
	private List<String> credit = new ArrayList<>();
	private List<String> voucher = new ArrayList<>();
}

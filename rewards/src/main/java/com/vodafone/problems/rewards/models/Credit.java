package com.vodafone.problems.rewards.models;

import lombok.Data;

@Data
public class Credit extends PersonalInfo {
	private String creditId;
	private int points;
	public Credit(){}
	public Credit(String creditId, int points, String firstName, String lastName) {
		this.creditId = creditId;
		this.points = points;
		super.setFirstName(firstName);
		super.setLastName(lastName);
	}
}

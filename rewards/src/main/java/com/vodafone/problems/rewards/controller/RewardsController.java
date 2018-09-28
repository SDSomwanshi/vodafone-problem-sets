package com.vodafone.problems.rewards.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.problems.rewards.models.Reward;
import com.vodafone.problems.rewards.service.RewardService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api")
public class RewardsController {
	private final RewardService rewardService;
	
	@ApiOperation(value="Fetch Rewards by Person")
    @ApiResponses(value = {
        @ApiResponse(code = 202, message = "Created", response = Reward.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
	@GetMapping("/rewards")
	public ResponseEntity<List<Reward>> fetchRewards() {
		log.info("Populating All reward details");
		return ResponseEntity.status(HttpStatus.OK).body(rewardService.getRewards());
	}
}

package com.vodafone.problems.credits.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.problems.credits.models.Credit;
import com.vodafone.problems.credits.service.CreditService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api")
public class CreditsController {
	private final CreditService creditSercide;
	
	@ApiOperation(value="Fetch All Credits")
    @ApiResponses(value = {
        @ApiResponse(code = 202, message = "Created", response = Credit.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
	@GetMapping("/credits")
	public ResponseEntity<List<Credit>> fetchAllCredits() {
		log.info("Populating All credit details");
		return ResponseEntity.status(HttpStatus.OK).body(creditSercide.getCredits());
	}
}

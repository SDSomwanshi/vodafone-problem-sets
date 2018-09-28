package com.vodafone.problems.voucher.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.problems.voucher.models.Voucher;
import com.vodafone.problems.voucher.service.VoucherService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api")
public class VouchersController {
	private final VoucherService voucherService;
	@ApiOperation(value="Fetch All Vouchers")
    @ApiResponses(value = {
        @ApiResponse(code = 202, message = "Created", response = Voucher.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
	@GetMapping("/vouchers")
	public ResponseEntity<List<Voucher>> fetchAllVouchers() {
		log.info("Populating All voucher details");
		return ResponseEntity.status(HttpStatus.OK).body(voucherService.getVouchers());
	}
}

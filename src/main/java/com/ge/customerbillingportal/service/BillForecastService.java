package com.ge.customerbillingportal.service;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;

import com.ge.customerbillingportal.dto.BillForecast;

public interface BillForecastService {

	public ResponseEntity<BillForecast> getBillForecast(Integer accountId, Long meterNumber, String currentDate)
			throws ParseException;

}

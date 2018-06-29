package com.ge.customerbillingportal.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ge.customerbillingportal.dto.LoadForecast;

public interface LoadForecastService {

	public ResponseEntity<List<LoadForecast>> getLoadForecastDayAhead(String currentDate, Integer accountId)
			throws ParseException;
	
	public ResponseEntity<List<LoadForecast>> getLoadForecastWeekAhead(String currentDate, Integer accountId)
			throws ParseException;
}

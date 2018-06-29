package com.ge.customerbillingportal.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ge.customerbillingportal.dto.UsageHistory;

public interface UsageHistoryService {

	public ResponseEntity<List<UsageHistory>> getUsageHistoryMonthly(String startDate, String endDate, Long meterNumber)
			throws ParseException;

	public ResponseEntity<List<UsageHistory>> getUsageHistoryDaily(String startDate, String endDate, Long meterNumber)
			throws ParseException;

	public ResponseEntity<List<UsageHistory>> getUsageHistoryWeekly(String startDate, String endDate, Long meterNumber,
			boolean previous) throws ParseException;

	public ResponseEntity<List<UsageHistory>> getUsageHistoryHourly(String currentDate, Long meterNumber,
			boolean custom) throws ParseException;

	public ResponseEntity<List<UsageHistory>> getUsageHistoryBillcycle(Integer accountId, Long meterNumber,
			boolean previous) throws ParseException;

}

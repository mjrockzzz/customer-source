package com.ge.customerbillingportal.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ge.customerbillingportal.dto.UsageHistory;

/**
 * @author Nitin K.
 * Interface containing methods to get usage history data
 */
public interface UsageHistoryService {

	/**
	 * @author Nitin K.
	 * @purpose to get usage history monthly
	 * @param startDate String
	 * @param endDate String
	 * @param meterNumber Long
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-10
	 */
	public ResponseEntity<List<UsageHistory>> getUsageHistoryMonthly(String startDate, String endDate, Long meterNumber)
			throws ParseException;

	/**
	 * @author Nitin K.
	 * @purpose to get usage history daily
	 * @param startDate String
	 * @param endDate String
	 * @param meterNumber Long
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */
	public ResponseEntity<List<UsageHistory>> getUsageHistoryDaily(String startDate, String endDate, Long meterNumber)
			throws ParseException;

	/**
	 * @author Nitin K.
	 * @purpose to get usage history weekly
	 * @param startDate String
	 * @param endDate String
	 * @param meterNumber Long
	 * @param previous Boolean
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */
	public ResponseEntity<List<UsageHistory>> getUsageHistoryWeekly(String startDate, String endDate, Long meterNumber,
			boolean previous) throws ParseException;

	/**
	 * @author Nitin K.
	 * @purpose to get usage history hourly
	 * @param currentDate String
	 * @param meterNumberLong 
	 * @param custom Boolean
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */
	public ResponseEntity<List<UsageHistory>> getUsageHistoryHourly(String currentDate, Long meterNumber,
			boolean custom) throws ParseException;

	/**
	 * @author Nitin K.
	 * @purpose to get usage history by bill cycle start date and end date
	 * @param accountId Integer
	 * @param meterNumber Long
	 * @param previous boolean
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */
	public ResponseEntity<List<UsageHistory>> getUsageHistoryBillcycle(Integer accountId, Long meterNumber,
			boolean previous) throws ParseException;

}

package com.ge.customerbillingportal.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ge.customerbillingportal.common.consts.UrlPathConstants;
import com.ge.customerbillingportal.dto.UsageHistory;
import com.ge.customerbillingportal.service.UsageHistoryService;

@RestController
@RequestMapping(value = UrlPathConstants.USAGE_HISTORY)
public class UsageHistoryController {

	private static final Logger logger = LoggerFactory.getLogger(UsageHistoryController.class);

	@Autowired
	private UsageHistoryService usageHistoryService;

	/**
	 * @author Nitin K.
	 * @purpose to get usage history monthly by default
	 * @param String
	 *            currentDate,Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-10
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_MONTHLY, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryMonthly(@RequestParam("currentDate") String currentDate,
			@RequestParam("meterNumber") Long meterNumber) throws ParseException {

		logger.info("Entered into getUsageHistoryMonthly controller.......");

		return usageHistoryService.getUsageHistoryMonthly(null, currentDate, meterNumber);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history monthly as per months given by user
	 * @param String
	 *            startDate, String endDate,Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-10
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_MONTHLY_CUSTOM, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryMonthlyCustom(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("meterNumber") Long meterNumber)
			throws ParseException {

		logger.info("Entered into getUsageHistoryMonthlyCustom controller.......");

		return usageHistoryService.getUsageHistoryMonthly(startDate, endDate, meterNumber);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history daily by default
	 * @param String
	 *            currentDate,Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_DAILY, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryDaily(@RequestParam("currentDate") String currentDate,
			@RequestParam("meterNumber") Long meterNumber) throws ParseException {

		logger.info("Entered into getUsageHistoryDaily controller.......");

		return usageHistoryService.getUsageHistoryDaily(null, currentDate, meterNumber);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history daily as per given dates
	 * @param String
	 *            startDate,String endDate,Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_DAILY_CUSTOM, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryDailyCustom(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("meterNumber") Long meterNumber)
			throws ParseException {

		logger.info("Entered into getUsageHistoryDailyCustom controller.......");
		return usageHistoryService.getUsageHistoryDaily(startDate, endDate, meterNumber);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history weekly by default
	 * @param String
	 *            currentDate, Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_WEEKLY, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryWeekly(@RequestParam("currentDate") String currentDate,
			@RequestParam("meterNumber") Long meterNumber) throws ParseException {

		logger.info("Entered into getUsageHistoryWeekly controller.......");

		return usageHistoryService.getUsageHistoryWeekly(null, currentDate, meterNumber, false);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history of previous week
	 * @param String
	 *            currentDate, Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_WEEKLY_PREVIOUS, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryWeeklyPrevious(
			@RequestParam("currentDate") String currentDate, @RequestParam("meterNumber") Long meterNumber)
			throws ParseException {

		logger.info("Entered into getUsageHistoryWeeklyPrevious controller.......");

		return usageHistoryService.getUsageHistoryWeekly(null, currentDate, meterNumber, true);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history weekly as per dates given by user
	 * @param String
	 *            startDate,String endDate, Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_WEEKLY_CUSTOM, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryWeeklyCustom(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("meterNumber") Long meterNumber)
			throws ParseException {

		logger.info("Entered into getUsageHistoryWeeklyCustom controller.......");

		return usageHistoryService.getUsageHistoryWeekly(startDate, endDate, meterNumber, false);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history hourly by default
	 * @param String
	 *            currentDate, Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_HOURLY, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryHourly(@RequestParam("currentDate") String currentDate,
			@RequestParam("meterNumber") Long meterNumber) throws ParseException {

		logger.info("Entered into getUsageHistoryHourly controller.......");

		return usageHistoryService.getUsageHistoryHourly(currentDate, meterNumber, false);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history hourly as per given date
	 * @param String
	 *            OfDate, Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_HOURLY_CUSTOM, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryHourlyCustom(@RequestParam("OfDate") String OfDate,
			@RequestParam("meterNumber") Long meterNumber) throws ParseException {

		logger.info("Entered into getUsageHistoryHourlyCustom controller.......");

		return usageHistoryService.getUsageHistoryHourly(OfDate, meterNumber, true);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history of current bill cycle
	 * @param Integer
	 *            accountId,Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_BILLCYCLE, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryBillCycle(
			@RequestParam(value = "accountId") Integer accountId, @RequestParam("meterNumber") Long meterNumber)
			throws ParseException {

		logger.info("Entered into getUsageHistoryBillCycle controller.......");

		return usageHistoryService.getUsageHistoryBillcycle(accountId, meterNumber, false);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history of previous bill cycle
	 * @param Integer
	 *            accountId,Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@RequestMapping(value = UrlPathConstants.USAGE_HISTORY_BILLCYCLE_PREVIOUS, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<UsageHistory>> getUsageHistoryBillCyclePrevious(
			@RequestParam(value = "accountId") Integer accountId, @RequestParam("meterNumber") Long meterNumber)
			throws ParseException {

		logger.info("Entered into getUsageHistoryBillCyclePrevious controller.......");

		return usageHistoryService.getUsageHistoryBillcycle(accountId, meterNumber, true);

	}

}

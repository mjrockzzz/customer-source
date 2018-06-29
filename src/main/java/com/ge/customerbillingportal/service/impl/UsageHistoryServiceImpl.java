package com.ge.customerbillingportal.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ge.customerbillingportal.dao.CustomerBillRepository;
import com.ge.customerbillingportal.dao.CustomerMeterIntervalDataRepository;
import com.ge.customerbillingportal.dto.UsageHistory;
import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.entity.CustomerBill;
import com.ge.customerbillingportal.entity.CustomerMeter;
import com.ge.customerbillingportal.service.UsageHistoryService;
import com.ge.customerbillingportal.util.DateUtility;

@Service
public class UsageHistoryServiceImpl implements UsageHistoryService {

	private static final Logger logger = LoggerFactory.getLogger(UsageHistoryServiceImpl.class);

	@Autowired
	private CustomerMeterIntervalDataRepository customerMeterIntervalDataRepository;

	@Autowired
	private CustomerBillRepository customerBillRepository;

	/**
	 * @author Nitin K.
	 * @purpose to get usage history monthly
	 * @param String
	 *            startDate, String endDate, Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-10
	 */

	@Override
	public ResponseEntity<List<UsageHistory>> getUsageHistoryMonthly(String startDate, String endDate, Long meterNumber)
			throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Entered into getUsageHistoryMonthly service method.......");
		java.sql.Date sqlStartDate = null;
		java.sql.Date sqlEndDate = null;
		boolean flag = false;
		java.sql.Date sqlfromDateModified = null;

		// Check For Current Month By default
		if (startDate == null) {
			sqlStartDate = DateUtility.getReducedSqlDatewithMonths(endDate, 12);
			sqlEndDate = DateUtility.getReducedSqlDatewithDays(endDate, 1);
		}

		// This is for selected custom months
		if (startDate != null && endDate != null) {

			// find the month difference
			int noOfmonths = DateUtility.getMonthDifference(startDate, endDate);

			// If month difference is greater than 12 modify start date
			if (noOfmonths > 12) {
				logger.debug("Months are grater than 12");
				flag = true;
				sqlfromDateModified = DateUtility.getReducedSqlDatewithMonths(endDate, 11);
				logger.debug("Sql New modifed start Date is" + sqlfromDateModified.toString());
			}

			sqlStartDate = DateUtility.getSqlDateFromStringDate(startDate);
			// Check start date is modified or not
			if (flag == true) {
				sqlStartDate = sqlfromDateModified;
			}
			sqlEndDate = DateUtility.getSqlDateFromStringDate(endDate);
		}

		// Set meter number to CustomerMeter
		CustomerMeter customerMeter = new CustomerMeter();
		BigDecimal newMeterNumber = new BigDecimal(meterNumber);
		customerMeter.setMeterNumber(newMeterNumber);

		// Call usage history with start date and end date
		List<Object[]> usageObjects = customerMeterIntervalDataRepository.findUsageHistoryMonthly(sqlStartDate,
				sqlEndDate, customerMeter);
		List<UsageHistory> usageHistories = new ArrayList<UsageHistory>();
		for (Object[] usageObject : usageObjects) {
			UsageHistory usageHistory = new UsageHistory();
			BigDecimal meternumber = (BigDecimal) usageObject[0];
			usageHistory.setMeternumber(meternumber);
			logger.debug("Meter no is" + meternumber);
			Date meterDate = (Date) usageObject[1];
			usageHistory.setMeterDate(meterDate);
			logger.debug("Meter date is" + meterDate);
			BigDecimal dailyLoad = (BigDecimal) usageObject[2];
			usageHistory.setDailyLoad(dailyLoad);
			logger.debug("daily load is" + dailyLoad);
			BigDecimal temperature = (BigDecimal) usageObject[3];
			usageHistory.setTemperature(temperature);
			logger.debug("tempearture is" + temperature);
			usageHistories.add(usageHistory);
		}

		return new ResponseEntity<List<UsageHistory>>(usageHistories, HttpStatus.OK);
	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history daily
	 * @param String
	 *            startDate, String endDate, Long meterNumber
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@Override
	public ResponseEntity<List<UsageHistory>> getUsageHistoryDaily(String startDate, String endDate, Long meterNumber)
			throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Entered into getUsageHistoryDaily service method.......");
		java.sql.Date sqlStartDate = null;
		java.sql.Date sqlEndDate = null;
		boolean flag = false;
		java.sql.Date sqlfromDateModified = null;

		// Check For Current Month By default
		if (startDate == null) {
			sqlStartDate = DateUtility.getReducedSqlDatewithDays(endDate, 30);
			sqlEndDate = DateUtility.getReducedSqlDatewithDays(endDate, 1);
		}

		// This is for selected custom months
		if (startDate != null && endDate != null) {
			// find the day difference
			int noOfDays = DateUtility.getDaysDifference(startDate, endDate);
			// If month difference is greater than 12 modify start date
			if (noOfDays > 30) {
				flag = true;
				logger.debug("Days are grater than 30");
				// Decide new start date ( end_date - 29 days)
				sqlfromDateModified = DateUtility.getReducedSqlDatewithDays(endDate, 29);
				logger.debug("Sql New modifed start Date is" + sqlfromDateModified.toString());
			}

			sqlStartDate = DateUtility.getSqlDateFromStringDate(startDate);
			// Check start date is modified or not
			if (flag == true) {
				sqlStartDate = sqlfromDateModified;
			}
			sqlEndDate = DateUtility.getSqlDateFromStringDate(endDate);
			logger.debug("Sql end date is" + sqlEndDate.toString());
		}

		// Set meter number to CustomerMeter
		CustomerMeter customerMeter = new CustomerMeter();
		BigDecimal newMeterNumber = new BigDecimal(meterNumber);
		customerMeter.setMeterNumber(newMeterNumber);

		// Call usage history with start date and end date
		List<Object[]> usageObjects = customerMeterIntervalDataRepository.findUsageHistoryDaily(sqlStartDate,
				sqlEndDate, customerMeter);
		List<UsageHistory> usageHistories = new ArrayList<UsageHistory>();
		for (Object[] usageObject : usageObjects) {
			UsageHistory usageHistory = new UsageHistory();
			BigDecimal meternumber = (BigDecimal) usageObject[0];
			usageHistory.setMeternumber(meternumber);
			logger.debug("Meter no is" + meternumber);
			Date meterDate = (Date) usageObject[1];
			usageHistory.setMeterDate(meterDate);
			logger.debug("Meter date is" + meterDate);
			BigDecimal dailyLoad = (BigDecimal) usageObject[2];
			usageHistory.setDailyLoad(dailyLoad);
			logger.debug("daily load is" + dailyLoad);
			BigDecimal temperature = (BigDecimal) usageObject[3];
			usageHistory.setTemperature(temperature);
			logger.debug("tempearture is" + temperature);
			usageHistories.add(usageHistory);
		}

		return new ResponseEntity<List<UsageHistory>>(usageHistories, HttpStatus.OK);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history weekly
	 * @param String
	 *            startDate, String endDate, Long meterNumber,boolean previous
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@Override
	public ResponseEntity<List<UsageHistory>> getUsageHistoryWeekly(String startDate, String endDate, Long meterNumber,
			boolean previous) throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Entered into getUsageHistoryWeekly service method.......");
		java.sql.Date sqlStartDate = null;
		java.sql.Date sqlEndDate = null;

		// This is for current week by default
		if (startDate == null) {
			sqlStartDate = DateUtility.getReducedSqlDatewithDays(endDate, 7);
			sqlEndDate = DateUtility.getReducedSqlDatewithDays(endDate, 1);
		}

		// This is for custom week selection
		if (startDate != null && endDate != null) {
			sqlStartDate = DateUtility.getSqlDateFromStringDate(startDate);
			sqlEndDate = DateUtility.getSqlDateFromStringDate(endDate);
		}

		// This is for previous week selection
		if (previous == true) {
			sqlStartDate = DateUtility.getReducedSqlDatewithDays(endDate, 14);
			sqlEndDate = DateUtility.getReducedSqlDatewithDays(endDate, 8);
		}

		logger.debug("Sql Strat Date for Weekly History is " + sqlStartDate.toString());
		logger.debug("Sql End Date for Weekly History is " + sqlEndDate.toString());

		// Set meter number to CustomerMeter
		CustomerMeter customerMeter = new CustomerMeter();
		BigDecimal newMeterNumber = new BigDecimal(meterNumber);
		customerMeter.setMeterNumber(newMeterNumber);

		// Call usage history with start date and end date
		List<Object[]> usageObjects = customerMeterIntervalDataRepository.findUsageHistoryWeekly(sqlStartDate,
				sqlEndDate, customerMeter);
		List<UsageHistory> usageHistories = new ArrayList<UsageHistory>();
		for (Object[] usageObject : usageObjects) {
			UsageHistory usageHistory = new UsageHistory();
			BigDecimal meternumber = (BigDecimal) usageObject[0];
			usageHistory.setMeternumber(meternumber);
			logger.debug("Meter no is" + meternumber);
			Date meterDate = (Date) usageObject[1];
			usageHistory.setMeterDate(meterDate);
			logger.debug("Meter date is" + meterDate);
			BigDecimal dailyLoad = (BigDecimal) usageObject[2];
			usageHistory.setDailyLoad(dailyLoad);
			logger.debug("daily load is" + dailyLoad);
			BigDecimal temperature = (BigDecimal) usageObject[3];
			usageHistory.setTemperature(temperature);
			logger.debug("tempearture is" + temperature);
			usageHistories.add(usageHistory);
		}

		return new ResponseEntity<List<UsageHistory>>(usageHistories, HttpStatus.OK);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history hourly
	 * @param String
	 *            currentDate, Long meterNumber,boolean custom
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@Override
	public ResponseEntity<List<UsageHistory>> getUsageHistoryHourly(String currentDate, Long meterNumber,
			boolean custom) throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Entered into getUsageHistoryHourly service method.......");
		java.sql.Date sqlOfDate = null;

		// Convert to sql date(CurrentDate-1)
		sqlOfDate = DateUtility.getReducedSqlDatewithDays(currentDate, 1);
		logger.debug("Sql  Date for Current Hourly History is" + sqlOfDate.toString());

		// This is for custom date selection
		if (custom == true) {
			sqlOfDate = DateUtility.getSqlDateFromStringDate(currentDate);
			logger.debug("Sql  Date for Custom Hourly History is" + sqlOfDate.toString());
		}

		// Set meter number to CustomerMeter
		CustomerMeter customerMeter = new CustomerMeter();
		BigDecimal newMeterNumber = new BigDecimal(meterNumber);
		customerMeter.setMeterNumber(newMeterNumber);

		// Call usage history with start date and end date
		List<Object[]> usageObjects = customerMeterIntervalDataRepository.findUsageHistoryHourly(sqlOfDate,
				customerMeter);
		List<UsageHistory> usageHistories = new ArrayList<UsageHistory>();
		for (Object[] usageObject : usageObjects) {
			UsageHistory usageHistory = new UsageHistory();
			BigDecimal meternumber = (BigDecimal) usageObject[0];
			usageHistory.setMeternumber(meternumber);
			logger.debug("Meter no is" + meternumber);
			Date meterDate = (Date) usageObject[1];
			usageHistory.setMeterDate(meterDate);
			logger.debug("Meter date is" + meterDate);
			BigDecimal dailyLoad = (BigDecimal) usageObject[2];
			usageHistory.setDailyLoad(dailyLoad);
			logger.debug("daily load is" + dailyLoad);
			BigDecimal temperature = (BigDecimal) usageObject[3];
			usageHistory.setTemperature(temperature);
			logger.debug("tempearture is" + temperature);
			Time metertime = (Time) usageObject[4];
			usageHistory.setMetertime(metertime);
			logger.debug("Meter time  is" + metertime);
			usageHistories.add(usageHistory);
		}

		return new ResponseEntity<List<UsageHistory>>(usageHistories, HttpStatus.OK);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get usage history by bill cycle start date and end date
	 * @param Integer
	 *            accountId, Long meterNumber,boolean previous
	 * @return ResponseEntity<List<UsageHistory>>
	 * @throws ParseException
	 * @date 2017-07-11
	 */

	@Override
	public ResponseEntity<List<UsageHistory>> getUsageHistoryBillcycle(Integer accountId, Long meterNumber,
			boolean previous) throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Entered into getUsageHistoryBillcycle service method.......");
		List<UsageHistory> usageHistories = new ArrayList<UsageHistory>();

		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setAccountId(accountId);

		List<CustomerBill> customerBills = customerBillRepository
				.findByCustomerAccountOrderByBillCycleEndDateDesc(customerAccount);
		logger.info("List size is" + customerBills.size());

		// Check list is empty or not
		if (customerBills.isEmpty() && customerBills.size() == 0) {
			return new ResponseEntity<List<UsageHistory>>(usageHistories, HttpStatus.NOT_FOUND);
		}

		// This is for current bill cycle
		CustomerBill customerBill = customerBills.get(0);
		logger.debug("Bill id is" + customerBill.getCustomerBillId());
		Date billCycleStartDate = customerBill.getBillCycleStartDate();
		Date billCycleEndDate = customerBill.getBillCycleEndDate();

		logger.debug("Bill cycle start date is" + customerBill.getBillCycleStartDate());
		logger.debug("Bill cycle end date is" + customerBill.getBillCycleEndDate());

		// Check for previous bill cycle
		if (previous == true) {
			logger.info("Entered into Previous bill cycle service method.......");
			CustomerBill customerBillPrevious = customerBills.get(1);

			// Check previous bill cycle bill exists or not
			if (customerBillPrevious == null) {
				return new ResponseEntity<List<UsageHistory>>(usageHistories, HttpStatus.NOT_FOUND);
			}

			logger.debug("Bill id is" + customerBillPrevious.getCustomerBillId());
			billCycleStartDate = customerBillPrevious.getBillCycleStartDate();
			billCycleEndDate = customerBillPrevious.getBillCycleEndDate();

			logger.debug(" Previous Bill cycle start date  is" + customerBillPrevious.getBillCycleStartDate());
			logger.debug("Previous cycle payment date is" + customerBillPrevious.getBillCycleEndDate());
		}

		// Set meter number to CustomerMeter
		CustomerMeter customerMeter = new CustomerMeter();
		BigDecimal newMeterNumber = new BigDecimal(meterNumber);
		customerMeter.setMeterNumber(newMeterNumber);

		List<Object[]> usageObjects = customerMeterIntervalDataRepository.findUsageHistoryDaily(billCycleStartDate,
				billCycleEndDate, customerMeter);

		for (Object[] usageObject : usageObjects) {
			UsageHistory usageHistory = new UsageHistory();
			BigDecimal meternumber = (BigDecimal) usageObject[0];
			usageHistory.setMeternumber(meternumber);
			logger.debug("Meter no is" + meternumber);
			Date meterDate = (Date) usageObject[1];
			usageHistory.setMeterDate(meterDate);
			logger.debug("Meter date is" + meterDate);
			BigDecimal dailyLoad = (BigDecimal) usageObject[2];
			usageHistory.setDailyLoad(dailyLoad);
			logger.debug("daily load is" + dailyLoad);
			BigDecimal temperature = (BigDecimal) usageObject[3];
			usageHistory.setTemperature(temperature);
			logger.debug("tempearture is" + temperature);
			usageHistories.add(usageHistory);
		}

		return new ResponseEntity<List<UsageHistory>>(usageHistories, HttpStatus.OK);

	}

}

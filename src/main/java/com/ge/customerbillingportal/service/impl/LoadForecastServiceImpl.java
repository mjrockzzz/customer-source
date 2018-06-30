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
import com.ge.customerbillingportal.dao.CustomerForecastIntervalDataRepository;
import com.ge.customerbillingportal.dto.LoadForecast;
import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.entity.CustomerBill;
import com.ge.customerbillingportal.service.LoadForecastService;
import com.ge.customerbillingportal.util.DateUtility;

/**
 * @author Nitin K.
 * Service class containing methods to get load forecast of a day ahead and a week ahead
 */
@Service
public class LoadForecastServiceImpl implements LoadForecastService {

	private static final Logger logger = LoggerFactory.getLogger(LoadForecastServiceImpl.class);

	@Autowired
	private CustomerForecastIntervalDataRepository customerForecastIntervalDataRepository;

	@Autowired
	private CustomerBillRepository customerBillRepository;

	/**
	 * @author Nitin K.
	 * @purpose to get load forecast of a day ahead
	 * @param currentDate String
	 * @param accountId Integer
	 * @return ResponseEntity<List<LoadForecast>>
	 * @throws ParseException
	 * @date 2017-07-12
	 */
	@Override
	public ResponseEntity<List<LoadForecast>> getLoadForecastDayAhead(String currentDate, Integer accountId)
			throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Entered into getLoadForecastDayAhead service method.......");

		// Decide start and end date (CurrentDate+1)
		java.sql.Date sqlStartTimeFromDate = DateUtility.getExtendedSqlDatewithDays(currentDate, 1);
		logger.debug("Sql New start and end  Date is" + sqlStartTimeFromDate.toString());

		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setAccountId(accountId);

		// Find Bill cycle date from account id
		List<CustomerBill> customerBills = customerBillRepository
				.findByCustomerAccountOrderByBillCycleEndDateDesc(customerAccount);
		logger.info("List size is" + customerBills.size());
		CustomerBill customerBill = customerBills.get(0);
		logger.debug("Bill id is" + customerBill.getCustomerBillId());
		Date billCycleEndDate = customerBill.getBillCycleEndDate();
		logger.debug("Bill cycle end date" + billCycleEndDate.toString());

		// Call load forecast with start date and account id
		List<Object[]> forecastObjects = customerForecastIntervalDataRepository
				.findLoadForecastDayAhead(sqlStartTimeFromDate, customerAccount.getAccountId());
		List<LoadForecast> loadforecasts = new ArrayList<LoadForecast>();
		for (Object[] forecastObject : forecastObjects) {
			LoadForecast loadForecast = new LoadForecast();
			// Set bill cycle date
			loadForecast.setBillCycleDate(billCycleEndDate);
			Integer customerAccountId = (Integer) forecastObject[0];
			loadForecast.setCustomerAccountId(customerAccountId);
			logger.debug("Customer account id is" + customerAccountId);
			Date forecastDate = (Date) forecastObject[1];
			loadForecast.setForecastDate(forecastDate);
			logger.debug("Forecast date is" + forecastDate);
			BigDecimal kWh = (BigDecimal) forecastObject[2];
			loadForecast.setkWh(kWh);
			logger.debug("KWh load is" + kWh);
			BigDecimal kVARH = (BigDecimal) forecastObject[3];
			loadForecast.setkVARH(kVARH);
			logger.debug("kVARH load is" + kVARH);
			BigDecimal temperature = (BigDecimal) forecastObject[4];
			loadForecast.setTemperature(temperature);
			logger.debug("tempearture is" + temperature);
			Time intervalTime = (Time) forecastObject[5];
			loadForecast.setIntervalTime(intervalTime);
			logger.debug("IntervalTime time  is" + intervalTime);
			loadforecasts.add(loadForecast);
		}

		return new ResponseEntity<List<LoadForecast>>(loadforecasts, HttpStatus.OK);

	}

	/**
	 * @author Nitin K.
	 * @purpose to get load forecast of a week ahead
	 * @param currentDate String
	 * @param accountId Integer
	 * @return ResponseEntity<List<LoadForecast>>
	 * @throws ParseException
	 * @date 2017-07-12
	 */
	@Override
	public ResponseEntity<List<LoadForecast>> getLoadForecastWeekAhead(String currentDate, Integer accountId)
			throws ParseException {
		// TODO Auto-generated method stub
		logger.info("Entered into getLoadForecastWeekAhead service method.......");

		// Decide start date (CurrentDate+1)
		java.sql.Date sqlStartTimeFromDate = DateUtility.getExtendedSqlDatewithDays(currentDate, 1);
		logger.debug("Sql New start and end  Date is" + sqlStartTimeFromDate.toString());

		// Decide end date (CurrentDate+7 days)
		java.sql.Date sqlEndTimeFromDate = DateUtility.getExtendedSqlDatewithDays(currentDate, 7);
		logger.debug("Sql start Date is" + sqlEndTimeFromDate.toString());

		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setAccountId(accountId);

		// Find Bill cycle date from account id
		List<CustomerBill> customerBills = customerBillRepository
				.findByCustomerAccountOrderByBillCycleEndDateDesc(customerAccount);
		logger.info("List size is" + customerBills.size());
		CustomerBill customerBill = customerBills.get(0);
		logger.debug("Bill id is" + customerBill.getCustomerBillId());
		Date billCycleEndDate = customerBill.getBillCycleEndDate();
		logger.debug("Bill cycle end date" + billCycleEndDate.toString());

		// Call load forecast with start date ,end date and account id
		List<Object[]> forecastObjects = customerForecastIntervalDataRepository
				.findLoadForecastWeekAhead(sqlStartTimeFromDate, sqlEndTimeFromDate, customerAccount.getAccountId());
		List<LoadForecast> loadforecasts = new ArrayList<LoadForecast>();
		for (Object[] forecastObject : forecastObjects) {
			LoadForecast loadForecast = new LoadForecast();
			// Set bill cycle date
			loadForecast.setBillCycleDate(billCycleEndDate);
			Integer customerAccountId = (Integer) forecastObject[0];
			loadForecast.setCustomerAccountId(customerAccountId);
			logger.debug("Customer account id is" + customerAccountId);
			Date forecastDate = (Date) forecastObject[1];
			loadForecast.setForecastDate(forecastDate);
			logger.debug("Forecast date is" + forecastDate);
			BigDecimal kWh = (BigDecimal) forecastObject[2];
			loadForecast.setkWh(kWh);
			logger.debug("KWh load is" + kWh);
			BigDecimal kVARH = (BigDecimal) forecastObject[3];
			loadForecast.setkVARH(kVARH);
			logger.debug("kVARH load is" + kVARH);
			BigDecimal temperature = (BigDecimal) forecastObject[4];
			loadForecast.setTemperature(temperature);
			logger.debug("tempearture is" + temperature);
			loadforecasts.add(loadForecast);
		}

		return new ResponseEntity<List<LoadForecast>>(loadforecasts, HttpStatus.OK);

	}

}

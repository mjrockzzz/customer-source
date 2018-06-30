package com.ge.customerbillingportal.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ge.customerbillingportal.dao.BillForecastRepository;
import com.ge.customerbillingportal.dao.CustomerBillRepository;
import com.ge.customerbillingportal.dao.CustomerForecastIntervalDataRepository;
import com.ge.customerbillingportal.dao.CustomerMeterIntervalDataRepository;
import com.ge.customerbillingportal.dto.BillForecast;
import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.entity.CustomerBill;
import com.ge.customerbillingportal.entity.CustomerMeter;
import com.ge.customerbillingportal.entity.CustomerMeterIntervalData;
import com.ge.customerbillingportal.service.BillForecastService;
import com.ge.customerbillingportal.util.DateUtility;

/**
 * @author Nitin K.
 * Service class containing methods to get forecast interval data
 */
@Service
public class BillForecastServiceImpl implements BillForecastService {

	private static final Logger logger = LoggerFactory.getLogger(BillForecastServiceImpl.class);

	@Autowired
	private CustomerMeterIntervalDataRepository customerMeterIntervalDataRepository;

	@Autowired
	private CustomerBillRepository customerBillRepository;

	@Autowired
	private CustomerForecastIntervalDataRepository customerForecastIntervalDataRepository;

	@Autowired
	private BillForecastRepository billForecastRepository;

	/**
	 * @author Nitin K.
	 * @purpose to get bill forecast interval data based on date
	 * @param accountId Integer
	 * @return ResponseEntity<CustomerAccount>
	 * @throws ParseException
	 * @date 2017-07-05
	 */

	@Override
	public ResponseEntity<BillForecast> getBillForecast(Integer accountId, Long meterNumber, String currentDate)
			throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Entered into getBillForecast service method.......");
		
		// Set Customer Account Id to CustomerAccount
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setAccountId(accountId);

		// Convert current date to sql date
		java.sql.Date sqlCurrentDate = DateUtility.getSqlDateFromStringDate(currentDate);

		BillForecast billForecast = new BillForecast();

		CustomerMeter customerMeter = new CustomerMeter();
		BigDecimal valDouble = new BigDecimal(meterNumber);
		customerMeter.setMeterNumber(valDouble);

		// Calculate Month To Date Consumption
		// Need to set startDate=billCycleEndDate+1
		// So first get billCycleEndDate
		List<CustomerBill> customerBills = customerBillRepository
				.findByCustomerAccountOrderByBillCycleEndDateDesc(customerAccount);
		logger.debug("List size is" + customerBills.size());

		// This is for current bill cycle
		CustomerBill customerBill = customerBills.get(0);
		logger.debug("Bill id is" + customerBill.getCustomerBillId());
		Date billCycleStartDate = customerBill.getBillCycleStartDate();
		Date billCycleEndDate = customerBill.getBillCycleEndDate();

		logger.debug("Bill cycle start date is" + customerBill.getBillCycleStartDate());
		logger.debug("Bill cycle end date is" + customerBill.getBillCycleEndDate());

		java.sql.Date sqlStartDateMonthsToDateCosumpn = DateUtility.getExtendedSqlDatewithDays(billCycleEndDate, 1);

		// Decide End date
		// endDate=currentDate-1
		java.sql.Date sqlEndDateMonthsToDateCosumpn = DateUtility.getReducedSqlDatewithDays(currentDate, 1);

		// Now call meter interval data with start and end date
		BigDecimal monthToDateConsumptionkWh = customerMeterIntervalDataRepository.findByCustomerMeterAndIntervalTime(
				sqlStartDateMonthsToDateCosumpn, sqlEndDateMonthsToDateCosumpn, customerMeter);
		logger.debug("Month To Date Consumption is " + monthToDateConsumptionkWh);
		billForecast.setMonthToDateConsumptionkWh(monthToDateConsumptionkWh);

		// Calculate Last months bill
		List<BigDecimal> lastMonthsBills = customerBillRepository.findByCustomerAccount(customerAccount);

		for (BigDecimal lastMonthBill : lastMonthsBills) {
			logger.debug("Last Months Bill " + lastMonthBill);
		}

		billForecast.setLastMonthsBills(lastMonthsBills);

		// Calculate last months consumption
		// Set start date and end dates as last months billCycleStartDate and
		// billCycleEndDate
		BigDecimal lastMonthsConsumptionkwh = customerMeterIntervalDataRepository
				.findByCustomerMeterAndIntervalTime(billCycleStartDate, billCycleEndDate, customerMeter);
		logger.debug("Last months consumption kwh is" + lastMonthsConsumptionkwh);
		billForecast.setLastMonthsConsumptionkWh(lastMonthsConsumptionkwh);

		// Calculate projected consumption for current month
		// Calculate sum(kWH) of current month
		BigDecimal projectedConsumpForCurrentMonth = customerForecastIntervalDataRepository
				.findKWhByCustomerAccount(DateUtility.getMonthFromSqlDate(sqlCurrentDate), customerAccount);
		billForecast.setProjectedConsumpForCurrentMonth(projectedConsumpForCurrentMonth);

		// Calculate estimated bill till today
		// Decide start time(billCycleEndDate+1)
		java.sql.Date sqlStartDateEstimatedBillTillToday = DateUtility.getExtendedSqlDatewithDays(billCycleEndDate, 1);

		// Decide End date
		// endDate=currentDate-1
		java.sql.Date sqlEndDateEstimatedBillTillToday = DateUtility.getReducedSqlDatewithDays(currentDate, 1);

		// Call meter interval data with start date and end date
		BigDecimal estimatedBillTillToday = customerMeterIntervalDataRepository.findBillByCustomerMeterAndIntervalTime(
				sqlStartDateEstimatedBillTillToday, sqlEndDateEstimatedBillTillToday, customerMeter);

		logger.debug("Estimated bill is" + estimatedBillTillToday);
		billForecast.setEstimatedBillTillToday(estimatedBillTillToday);

		// Calculate estimated bill of month
		BigDecimal estimatedBillOfMonth = billForecastRepository
				.findEstimatedBillByCustomerAccountAndIntervalTime(customerAccount);
		logger.debug("Estimated bill of month is" + estimatedBillOfMonth);
		billForecast.setEstimatedBillForCurrentMonth(estimatedBillOfMonth);

		// Find last meter interval read
		List<CustomerMeterIntervalData> customerMeterIntervalDatas = customerMeterIntervalDataRepository
				.findByCustomerMeterOrderByIntervalTimeDesc(customerMeter);
		logger.debug("List size is" + customerMeterIntervalDatas.size());
		CustomerMeterIntervalData customerMeterIntervalData = customerMeterIntervalDatas.get(0);
		logger.debug("Last Meter Interval Read is" + customerMeterIntervalData.getIntervalTime().toString());
		billForecast.setLastMeterIntervalRead(customerMeterIntervalData.getIntervalTime());
		return new ResponseEntity<BillForecast>(billForecast, HttpStatus.OK);

	}

}

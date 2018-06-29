package com.ge.customerbillingportal.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ge.customerbillingportal.dao.CustomerBillRepository;
import com.ge.customerbillingportal.dao.CustomerForecastIntervalDataRepository;
import com.ge.customerbillingportal.dto.ComparePlan;
import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.entity.CustomerBill;
import com.ge.customerbillingportal.service.ComparePlanService;
import com.ge.customerbillingportal.util.DateUtility;

@Service
public class ComparePlanServiceImpl implements ComparePlanService {

	private static final Logger logger = LoggerFactory.getLogger(ComparePlanServiceImpl.class);

	@Autowired
	private CustomerBillRepository customerBillRepository;
	
	@Autowired
	private CustomerForecastIntervalDataRepository customerForecastIntervalDataRepository;
	
	/**
	 * @author Nitin K.
	 * @purpose to get alternate rate plan and amount
	 * @param String
	 *            currentDate,Integer accountId
	 * @return ResponseEntity<ComparePlan>
	 * @throws ParseException 
	 * @date 2017-07-17
	 */


	@Override
	public ResponseEntity<ComparePlan> getAlternatePlanData(Integer accountId,String currentDate) throws ParseException {
		// TODO Auto-generated method stub
		
		logger.info("Entered into getAlternatePlanData service method.......");

		// Set accountId to CustomerAccount
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setAccountId(accountId);
		BigDecimal annualforecastIntervalamount=null;
		BigDecimal savingAmount=null;

		// get the latest bill from CustomerBill
		List<CustomerBill> customerBills = customerBillRepository
				.findByCustomerAccountOrderByBillCycleEndDateDesc(customerAccount);
		logger.info("List size is" + customerBills.size());
		CustomerBill customerBill = customerBills.get(0);
		logger.info("Bill id is" + customerBill.getCustomerBillId());
		logger.info("Bill cycle start date is" + customerBill.getBillCycleEndDate());
		
		java.sql.Date OfDate=DateUtility.getSqlDateFromStringDate(currentDate);
		Integer currentMonth=DateUtility.getMonthFromSqlDate(OfDate);
		
		BigDecimal forecastIntervalamount=customerForecastIntervalDataRepository.findIntervalAmountByCustomerAccount(currentMonth, customerAccount);
		 BigDecimal multiplicand = new BigDecimal(12);
		 if(forecastIntervalamount!=null){
				 annualforecastIntervalamount=forecastIntervalamount.multiply(multiplicand); 
		 }
	
		
		//Calculate saving amount
		
		BigDecimal subtrahend=customerBill.getAlternateRateAmount();
		if(annualforecastIntervalamount!=null && subtrahend!=null){
		   savingAmount=annualforecastIntervalamount.subtract(subtrahend);
		}
		
		logger.info("Forecast annual amount is"+annualforecastIntervalamount);
		
		// Set values of ComparePlan
		ComparePlan comparePlan = new ComparePlan();
		comparePlan.setCurrentPlan(customerBill.getRatePlan());
		comparePlan.setAlternateRatePlan(customerBill.getAlternateRatePlan());
		comparePlan.setAlternateRateAmount(customerBill.getAlternateRateAmount());
		comparePlan.setProjectedAnnualAmount(annualforecastIntervalamount);
		comparePlan.setSavingAmount(savingAmount);

		return new ResponseEntity<ComparePlan>(comparePlan, HttpStatus.OK);
	}

}

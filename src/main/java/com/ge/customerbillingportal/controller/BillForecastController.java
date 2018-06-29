package com.ge.customerbillingportal.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ge.customerbillingportal.common.consts.UrlPathConstants;
import com.ge.customerbillingportal.dto.BillForecast;
import com.ge.customerbillingportal.service.BillForecastService;

@RestController
@RequestMapping(value = UrlPathConstants.BILL_FORECAST)
public class BillForecastController {

	private static final Logger logger = LoggerFactory.getLogger(BillForecastController.class);

	@Autowired
	private BillForecastService  billForecastService;

	/**
	 * @author Nitin K.
	 * @purpose to get bill forecast interval data based on date
	 * @param Integer
	 *            accountId
	 * @return ResponseEntity<CustomerAccount>
	 * @throws ParseException
	 * @date 2017-07-05
	 */

	@RequestMapping(value = UrlPathConstants.BILL_FORECAST_DATA, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<BillForecast> getBillForecast(@RequestParam(value = "accountId") Integer accountId,
			@RequestParam("meterNumber") Long meterNumber, @RequestParam("currentDate") String currentDate)
			throws ParseException {

		logger.info("Entered into getBillForecast controller.......");
		
		return billForecastService.getBillForecast(accountId, meterNumber, currentDate);

	}

}

package com.ge.customerbillingportal.service;

import java.text.ParseException;
import org.springframework.http.ResponseEntity;
import com.ge.customerbillingportal.dto.BillForecast;

/**
 * @author Nitin K.
 * Interface containing methods to get forecast interval data
 */
public interface BillForecastService {

	/**
	 * @author Nitin K.
	 * @purpose to get bill forecast interval data based on date
	 * @param accountId Integer
	 * @return ResponseEntity<CustomerAccount>
	 * @throws ParseException
	 * @date 2017-07-05
	 */
	public ResponseEntity<BillForecast> getBillForecast(Integer accountId, Long meterNumber, String currentDate)
			throws ParseException;

}

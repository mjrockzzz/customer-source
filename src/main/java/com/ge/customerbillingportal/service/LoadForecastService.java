package com.ge.customerbillingportal.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ge.customerbillingportal.dto.LoadForecast;

/**
 * @author Nitin K.
 * Interface containing methods to get load forecast of a day ahead and a week ahead
 */
public interface LoadForecastService {

	/**
	 * @author Nitin K.
	 * @purpose to get load forecast of a day ahead
	 * @param currentDate String
	 * @param accountId Integer
	 * @return ResponseEntity<List<LoadForecast>>
	 * @throws ParseException
	 * @date 2017-07-12
	 */
	public ResponseEntity<List<LoadForecast>> getLoadForecastDayAhead(String currentDate, Integer accountId)
			throws ParseException;
	
	/**
	 * @author Nitin K.
	 * @purpose to get load forecast of a week ahead
	 * @param currentDate String
	 * @param accountId Integer
	 * @return ResponseEntity<List<LoadForecast>>
	 * @throws ParseException
	 * @date 2017-07-12
	 */
	public ResponseEntity<List<LoadForecast>> getLoadForecastWeekAhead(String currentDate, Integer accountId)
			throws ParseException;
}

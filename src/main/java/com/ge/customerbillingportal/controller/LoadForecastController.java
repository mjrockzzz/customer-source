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
import com.ge.customerbillingportal.dto.LoadForecast;
import com.ge.customerbillingportal.service.LoadForecastService;

/**
 * @author Nitin K.
 * Contains APIs to get load forecast of  day ahead and week ahead
 */
@RestController
@RequestMapping(value = UrlPathConstants.LOAD_FORECAST)
public class LoadForecastController {

	private static final Logger logger = LoggerFactory.getLogger(LoadForecastController.class);

	@Autowired
	private LoadForecastService loadForecastService;

	/**
	 * @author Nitin K.
	 * @purpose to get load forecast of a day ahead
	 * @param currentDate String
	 * @param accountId Integer
	 * @return ResponseEntity<List<LoadForecast>>
	 * @throws ParseException
	 * @date 2017-07-12
	 */

	@RequestMapping(value = UrlPathConstants.LOAD_FORECAST_DAY_AHEAD, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<LoadForecast>> getLoadForecastDayAhead(@RequestParam("currentDate") String currentDate,
			@RequestParam(value = "accountId") Integer accountId) throws ParseException {

		logger.info("Entered into getLoadForecastDayAhead controller.......");

		return loadForecastService.getLoadForecastDayAhead(currentDate, accountId);

	}
	
	
	/**
	 * @author Nitin K.
	 * @purpose to get load forecast of a week ahead
	 * @param String
	 *            currentDate,Integer accountId
	 * @return ResponseEntity<List<LoadForecast>>
	 * @throws ParseException
	 * @date 2017-07-12
	 */

	@RequestMapping(value = UrlPathConstants.LOAD_FORECAST_WEEK_AHEAD, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<List<LoadForecast>> getLoadForecastWeekAhead(@RequestParam("currentDate") String currentDate,
			@RequestParam(value = "accountId") Integer accountId) throws ParseException {

		logger.info("Entered into getLoadForecastDayAhead controller.......");

		return loadForecastService.getLoadForecastWeekAhead(currentDate, accountId);

	}


}

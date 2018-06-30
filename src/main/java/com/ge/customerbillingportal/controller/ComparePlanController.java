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
import com.ge.customerbillingportal.dto.ComparePlan;
import com.ge.customerbillingportal.service.ComparePlanService;

/**
 * @author Nitin K.
 * Contains API to get alternate rate plan and amount
 */
@RestController
@RequestMapping(value = UrlPathConstants.COMPARE_PLAN)
public class ComparePlanController {

	private static final Logger logger = LoggerFactory.getLogger(ComparePlanController.class);

	@Autowired
	private ComparePlanService comparePlanService;

	/**
	 * @author Nitin K.
	 * @purpose to get alternate rate plan and amount
	 * @param currentDate String
	 * @param accountId Integer
	 * @return ResponseEntity<ComparePlan>
	 * @throws ParseException 
	 * @date 2017-07-17
	 */

	@RequestMapping(value = UrlPathConstants.COMPARE_PLAN_DATA, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<ComparePlan> getAlternatePlanData(@RequestParam("currentDate") String currentDate,
			@RequestParam(value = "accountId") Integer accountId) throws ParseException {

		logger.info("Entered into getAlternatePlanData controller.......");

		return comparePlanService.getAlternatePlanData(accountId, currentDate);

	}

}

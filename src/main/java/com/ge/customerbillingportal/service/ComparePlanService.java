package com.ge.customerbillingportal.service;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;

import com.ge.customerbillingportal.dto.ComparePlan;

/**
 * @author Nitin K.
 * Interface containing methods to get alternate rate plan and amount
 */
public interface ComparePlanService {
	
	/**
	 * @author Nitin K.
	 * @purpose to get alternate rate plan and amount
	 * @param currentDate String
	 * @param accountId Integer
	 * @return ResponseEntity<ComparePlan>
	 * @throws ParseException 
	 * @date 2017-07-17
	 */
	public ResponseEntity<ComparePlan> getAlternatePlanData(Integer accountId,String currentDate)throws ParseException;

}

package com.ge.customerbillingportal.service;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;

import com.ge.customerbillingportal.dto.ComparePlan;

public interface ComparePlanService {
	
	public ResponseEntity<ComparePlan> getAlternatePlanData(Integer accountId,String currentDate)throws ParseException;

}

package com.ge.customerbillingportal.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ge.customerbillingportal.common.Manifest;
import com.ge.customerbillingportal.common.ResultModel;

/**
 * @author Nitin K.
 * Contains APIs for common controller
 *
 */
@RestController
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	

	@RequestMapping(value = "/")
	public Object home() {
		return new Manifest();
	}

	
	@RequestMapping(value = "/testauth")
	@PreAuthorize("hasRole('TEST')")
	public ResultModel testAuth(@RequestBody JSONObject params) {
		return ResultModel.SUCCESS(params);
	}

	@RequestMapping(value = "/hello")
	@PreAuthorize("hasRole('TEST')")
	public String hello() throws ParseException {
		logger.info("Entered into hello controller.....");
		return "Hello Nitin Welocme To Spring Boot...";
	}
	
	 

}

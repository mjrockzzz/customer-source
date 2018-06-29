package com.ge.customerbillingportal.util;

import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtility {

	private static final Logger logger = LoggerFactory.getLogger(DateUtility.class);

	/**
	 * @author Nitin K.
	 * @purpose to get sql date with reduced given days
	 * @param String
	 *            inputDate, int noOfDays
	 * @return java.sql.Date
	 * @throws ParseException
	 */

	public static java.sql.Date getReducedSqlDatewithDays(String inputDate, int noOfDays) throws ParseException {

		logger.debug("Entered into DateUtility......");
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
		java.util.Date inputDateParsed = format.parse(inputDate);

		// Reduce date with no of given days
		Calendar c1 = Calendar.getInstance();
		c1.setTime(inputDateParsed);
		logger.debug("Current Date is" + c1.getTime());
		c1.add(Calendar.DATE, -noOfDays); // number of days to reduce
		// Convert it to sql date
		java.sql.Date reducedSqlDate = new java.sql.Date(c1.getTimeInMillis());
		logger.debug("Sql Date with reduced days is" + reducedSqlDate.toString());
		return reducedSqlDate;

	}

	/**
	 * @author Nitin K.
	 * @purpose to get sql date with added given days
	 * @param String
	 *            inputDate, int noOfDays
	 * @return java.sql.Date
	 * @throws ParseException
	 */

	public static java.sql.Date getExtendedSqlDatewithDays(String inputDate, int noOfDays) throws ParseException {

		logger.debug("Entered into DateUtility......");
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
		java.util.Date inputDateParsed = format.parse(inputDate);

		// Reduce date with no of given days
		Calendar c1 = Calendar.getInstance();
		c1.setTime(inputDateParsed);
		logger.debug("Current Date is" + c1.getTime());
		c1.add(Calendar.DATE, noOfDays); // number of days to add
		// Convert it to sql date
		java.sql.Date reducedSqlDate = new java.sql.Date(c1.getTimeInMillis());
		logger.debug("Sql Date with added days is" + reducedSqlDate.toString());
		return reducedSqlDate;

	}

	/**
	 * @author Nitin K.
	 * @purpose to get sql date with reduced given months
	 * @param String
	 *            inputDate, int noOfmonths
	 * @return java.sql.Date
	 * @throws ParseException
	 */

	public static java.sql.Date getReducedSqlDatewithMonths(String inputDate, int noOfmonths) throws ParseException {

		logger.debug("Entered into DateUtility......");
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
		java.util.Date inputDateParsed = format.parse(inputDate);

		// Reduce date with no of given days
		Calendar c1 = Calendar.getInstance();
		c1.setTime(inputDateParsed);
		logger.debug("Current Date is" + c1.getTime());
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.add(Calendar.MONTH, -noOfmonths); // number of months to reduce
		// Convert it to sql date
		java.sql.Date reducedSqlDate = new java.sql.Date(c1.getTimeInMillis());
		logger.debug("Sql  with reduced months is" + reducedSqlDate.toString());
		return reducedSqlDate;

	}

	/**
	 * @author Nitin K.
	 * @purpose to get sql date with added given months
	 * @param String
	 *            inputDate, int noOfmonths
	 * @return java.sql.Date
	 * @throws ParseException
	 */

	public static java.sql.Date getExtendedSqlDatewithMonths(String inputDate, int noOfmonths) throws ParseException {

		logger.debug("Entered into DateUtility......");
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
		java.util.Date inputDateParsed = format.parse(inputDate);

		// Reduce date with no of given days
		Calendar c1 = Calendar.getInstance();
		c1.setTime(inputDateParsed);
		logger.debug("Current Date is" + c1.getTime());
		c1.add(Calendar.MONTH, noOfmonths); // number of months to add
		// Convert it to sql date
		java.sql.Date reducedSqlDate = new java.sql.Date(c1.getTimeInMillis());
		logger.debug("Sql  with reduced months is" + reducedSqlDate.toString());
		return reducedSqlDate;

	}

	/**
	 * @author Nitin K.
	 * @purpose to get sql date from String Date
	 * @param String
	 *            inputDate
	 * @return java.sql.Date
	 * @throws ParseException
	 */

	public static java.sql.Date getSqlDateFromStringDate(String inputDate) throws ParseException {

		logger.debug("Entered into DateUtility......");
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
		java.util.Date inputDateParsed = format.parse(inputDate);
		// Set to Calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(inputDateParsed);
		logger.debug("Current Date is" + c1.getTime());
		// Convert it to sql date
		java.sql.Date reducedSqlDate = new java.sql.Date(c1.getTimeInMillis());
		logger.debug("New sql date is" + reducedSqlDate.toString());
		return reducedSqlDate;

	}

	/**
	 * @author Nitin K.
	 * @purpose to get difference between dates in terms of months
	 * @param String
	 *            startDate, String endDate
	 * @return int noOfmonths
	 * @throws ParseException
	 */

	public static int getMonthDifference(String startDate, String endDate) throws ParseException {

		logger.debug("Entered into DateUtility......");
		// Parse the received date
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
		java.util.Date fromDate = format.parse(startDate);
		java.util.Date toDate = format.parse(endDate);

		// find the month difference
		Calendar beginningDate = Calendar.getInstance();
		beginningDate.setTime(fromDate);

		Calendar endingDate = Calendar.getInstance();
		endingDate.setTime(toDate);

		int m1 = beginningDate.get(Calendar.YEAR) * 12 + beginningDate.get(Calendar.MONTH);
		int m2 = endingDate.get(Calendar.YEAR) * 12 + endingDate.get(Calendar.MONTH);
		int noOfmonths = m2 - m1 + 1;
		logger.debug("Months diffrence is " + noOfmonths);
		return noOfmonths;
	}

	/**
	 * @author Nitin K.
	 * @purpose to get difference between dates in terms of days
	 * @param String
	 *            startDate, String endDate
	 * @return int noOfdays
	 * @throws ParseException
	 */

	public static int getDaysDifference(String startDate, String endDate) throws ParseException {
		logger.debug("Entered into DateUtility......");
		// Parse the received date
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
		java.util.Date fromDate = format.parse(startDate);
		java.util.Date toDate = format.parse(endDate);

		// Find the no of days between start date and end date
		int noOfdays = (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
		noOfdays = noOfdays + 1;

		return noOfdays;
	}

	/**
	 * @author Nitin K.
	 * @purpose to get sql date with added given days
	 * @param Date
	 *            inputDate, int noOfDays
	 * @return java.sql.Date
	 * @throws ParseException
	 */

	public static java.sql.Date getExtendedSqlDatewithDays(Date inputDate, int noOfDays) throws ParseException {

		logger.debug("Entered into DateUtility......");

		// Reduce date with no of given days
		Calendar c1 = Calendar.getInstance();
		c1.setTime(inputDate);
		logger.debug("Current Date is" + c1.getTime());
		c1.add(Calendar.DATE, noOfDays); // number of days to add
		// Convert it to sql date
		java.sql.Date reducedSqlDate = new java.sql.Date(c1.getTimeInMillis());
		logger.debug("Sql Date with added days is" + reducedSqlDate.toString());
		return reducedSqlDate;

	}

	/**
	 * @author Nitin K.
	 * @purpose to get month of given date
	 * @param java.sql.Date
	 *            inputDate
	 * @return int month
	 * @throws ParseException
	 */

	public static int getMonthFromSqlDate(java.sql.Date inputDate) {
		// Create Calendar instance and get required params
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		int month = cal.get(Calendar.MONTH);
		month = month + 1;
		logger.debug("Current month is" + month);
		return month;
	}

}

package com.ge.customerbillingportal.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.entity.CustomerForecastIntervalData;

public interface CustomerForecastIntervalDataRepository extends CrudRepository<CustomerForecastIntervalData, Integer> {

	@Query("SELECT sum(kWH) FROM CustomerForecastIntervalData WHERE month(intervalTime)=:OfMonth  AND customerAccount= :customerAccount")
	public BigDecimal findKWhByCustomerAccount(@Param("OfMonth") Integer OfMonth,@Param("customerAccount") CustomerAccount customerAccount);
	
	@Query("SELECT sum(intervalAmount) FROM CustomerForecastIntervalData WHERE month(intervalTime)=:month AND customerAccount = :customerAccount group by month(intervalTime)")
	public BigDecimal findIntervalAmountByCustomerAccount(@Param("month") Integer month,@Param("customerAccount") CustomerAccount customerAccount);
	
	
	//Day Ahead(Hourly of particular day)
	 public static final String FIND_DAY_AHEAD= "select acct_id, date(interval_time) meterdate, kWH,kvarh,temperature, time(interval_time) metertime from cust_forecast_interval_data where date(interval_time) =:Ofdate and acct_id =:customerAccount";

	 //Week Ahead
	 public static final String FIND_WEEK_AHEAD= "select acct_id, date(interval_time) meterdate,sum(kWH) daily_load,sum(kvarh),max(temperature) temperature from cust_forecast_interval_data where date(interval_time) between :fromDate and :toDate and acct_id =:customerAccount group by date(interval_time) order by interval_time";
	 
	// public static final String PROJECTED_CONSUMPTION="select sum(kwh) FROM cust_forecast_interval_data where  month(interval_time)=:OfMonth and acct_id =:customerAccount";
	 
	 @Query(value = FIND_DAY_AHEAD, nativeQuery = true)
	 public List<Object[]> findLoadForecastDayAhead(@Param("Ofdate") Date Ofdate,@Param("customerAccount") Integer customerAccount);
	 
	 @Query(value = FIND_WEEK_AHEAD, nativeQuery = true)
	 public List<Object[]> findLoadForecastWeekAhead(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("customerAccount") Integer customerAccount);
	
}

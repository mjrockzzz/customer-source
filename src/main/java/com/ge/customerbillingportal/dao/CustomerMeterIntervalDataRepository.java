package com.ge.customerbillingportal.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.customerbillingportal.entity.CustomerMeter;
import com.ge.customerbillingportal.entity.CustomerMeterIntervalData;

public interface CustomerMeterIntervalDataRepository extends CrudRepository<CustomerMeterIntervalData, Integer> {

	
	@Query("SELECT sum(kWH) FROM CustomerMeterIntervalData WHERE date(intervalTime) BETWEEN :fromDate AND :toDate AND customerMeter = :meterNumber ")
	public BigDecimal findByCustomerMeterAndIntervalTime(@Param("fromDate") Date fromDate,
			@Param("toDate") Date toDate, @Param("meterNumber") CustomerMeter customerMeter);

	// Monthly
	public static final String FIND_MONTHLY = "select meter_num, date(interval_time) meterdate,sum(kWH) daily_load,max(temperature) temperature from cust_meter_interval_data where date(interval_time) between :fromDate and :toDate and meter_num =:meterNumber group by month(interval_time) order by interval_time";
	// Weekly
	public static final String FIND_WEEKLY = "select meter_num, date(interval_time) meterdate,sum(kWH) daily_load,max(temperature) temperature from cust_meter_interval_data where date(interval_time) between :fromDate and :toDate and meter_num =:meterNumber group by date(interval_time) order by interval_time";
	// Daily
	public static final String FIND_DAILY = "select meter_num, date(interval_time) meterdate,sum(kWH),max(temperature) temperature from cust_meter_interval_data where date(interval_time) between :fromDate and :toDate and meter_num =:meterNumber  group by date(interval_time) order by interval_time";
	// Hourly
	public static final String FIND_HOURLY = "select meter_num, date(interval_time) meterdate, kWH,temperature, time(interval_time) metertime from cust_meter_interval_data where date(interval_time) =:Ofdate and meter_num =:meterNumber order by time(interval_time) ";

	// Estimated Bill till today
	public static final String ESTIMATED_BILL_TLL_TODAY = "select meter_num,sum(interval_amt)from cust_meter_interval_data  from cust_meter_interval_data where date(interval_time) =:Ofdate and meter_num =:meterNumber ";

	@Query(value = FIND_MONTHLY, nativeQuery = true)
	public List<Object[]> findUsageHistoryMonthly(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate,
			@Param("meterNumber") CustomerMeter meterNumber);

	@Query(value = FIND_WEEKLY, nativeQuery = true)
	public List<Object[]> findUsageHistoryWeekly(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate,
			@Param("meterNumber") CustomerMeter meterNumber);

	@Query(value = FIND_DAILY, nativeQuery = true)
	public List<Object[]> findUsageHistoryDaily(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate,
			@Param("meterNumber") CustomerMeter meterNumber);

	@Query(value = FIND_HOURLY, nativeQuery = true)
	public List<Object[]> findUsageHistoryHourly(@Param("Ofdate") Date Ofdate,
			@Param("meterNumber") CustomerMeter meterNumber);

	@Query("SELECT sum(intervalAmount) FROM CustomerMeterIntervalData WHERE date(intervalTime) BETWEEN :fromDate AND :toDate AND customerMeter = :customerMeter")
	public BigDecimal findBillByCustomerMeterAndIntervalTime(@Param("fromDate") Date fromDate,
			@Param("toDate") Date toDate, @Param("customerMeter") CustomerMeter customerMeter);
	

	List<CustomerMeterIntervalData> findByCustomerMeterOrderByIntervalTimeDesc(CustomerMeter customerMeter);

}

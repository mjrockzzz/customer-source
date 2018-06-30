package com.ge.customerbillingportal.dao;

import org.springframework.data.repository.CrudRepository;

import com.ge.customerbillingportal.entity.AdminAccount;

/**
 * @author Nitin K.
 * Interface contains method to get AdminAccount data from database
 */
public interface AdminAccountRepository extends CrudRepository <AdminAccount, Long> {

	/**
	 * Method to get AdminAccount for given adminName from database
	 * @param adminName String
	 * @return AdminAccount 
	 */
    public AdminAccount findByAdminName(String adminName);

}

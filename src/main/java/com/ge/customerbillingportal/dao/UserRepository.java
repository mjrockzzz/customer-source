package com.ge.customerbillingportal.dao;

import org.springframework.data.repository.CrudRepository;

import com.ge.customerbillingportal.entity.User;

/**
 * @author Nitin K.
 * Interface to get user from database.
 */
public interface UserRepository extends CrudRepository<User, Long> {

	/**
	 * Method to get user for given userName from database
	 * @param username String
	 * @return User
	 */
	public User findByUsername(String username);

}

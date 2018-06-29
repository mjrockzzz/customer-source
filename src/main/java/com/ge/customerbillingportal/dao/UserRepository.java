package com.ge.customerbillingportal.dao;

import org.springframework.data.repository.CrudRepository;

import com.ge.customerbillingportal.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);

}

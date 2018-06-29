package com.ge.customerbillingportal.dao;

import org.springframework.data.repository.CrudRepository;

import com.ge.customerbillingportal.entity.AdminAccount;

public interface AdminAccountRepository extends CrudRepository <AdminAccount, Long> {

    public AdminAccount findByAdminName(String adminName);

}

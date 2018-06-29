package com.ge.customerbillingportal.service.impl;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.customerbillingportal.dao.CustomerAccountRepository;
import com.ge.customerbillingportal.dto.WSCustomerAccount;
import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	
	@Autowired
    DozerBeanMapper dozerBeanMapper;

    static Mapper mapper = new DozerBeanMapper();
    
	@Autowired
	private CustomerAccountRepository customerAccountRepository;
	
	/**
	 * @author Nitin K.
	 * @purpose to get customer all data from account id
	 * @param Integer accountId
	 * @return CustomerAccount
	 * @date 2017-07-06
	 */

	@Override
	public WSCustomerAccount getCustomerByAccountId(Integer accountId) {
		// TODO Auto-generated method stub

		logger.info("Entered into getCustomerByAccountId service method.....");
		WSCustomerAccount wsCustomerAccount = new WSCustomerAccount();
		CustomerAccount customerAccount = customerAccountRepository.findByAccountId(accountId);
		
		wsCustomerAccount = mapper.map(customerAccount, WSCustomerAccount.class);
		return wsCustomerAccount;
		
	}

}

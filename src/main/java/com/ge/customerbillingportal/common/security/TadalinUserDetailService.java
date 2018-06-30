package com.ge.customerbillingportal.common.security;

import com.ge.customerbillingportal.common.consts.RecordStatus;
import com.ge.customerbillingportal.common.exception.AccountFrozenException;
import com.ge.customerbillingportal.common.exception.AccountNotExistException;
import com.ge.customerbillingportal.dao.AdminAccountRepository;
import com.ge.customerbillingportal.entity.AdminAccount;
import com.ge.customerbillingportal.mapper.AuthMapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nitin K.
 * Class containing service to get user details
 */
@Service
@Primary
public class TadalinUserDetailService implements UserDetailsService {

    @Autowired
    private AdminAccountRepository adminAccountRepository;

    @Autowired
    private AuthMapper authMapper;

   // @Autowired
    //private Environment environment;

    @Override
    public TadalinUserDetail loadUserByUsername(String s) throws UsernameNotFoundException {

        if(StringUtils.isBlank(s)) {
            throw new AccountNotExistException();
        }

        //Step-01: Find a user by name Entity
        AdminAccount account = adminAccountRepository.findByAdminName(s);

        if (null == account) {
            throw new AccountNotExistException();
        }

        if(account.getStatus().equals(RecordStatus.FROZEN)) {
            throw new AccountFrozenException();
        }

        //Step-02: Find user roles, comes with default ROLE_ADMIN
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_TEST"));
        List<String> roles = authMapper.findRolesByAdminId(account.getId());

        if(roles != null && roles.size() > 0) {
            roles.stream().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(String.format("ROLE_%s", role.toUpperCase().trim())));
            });
        }
        return new TadalinUserDetail(account, authorities);
    }
}

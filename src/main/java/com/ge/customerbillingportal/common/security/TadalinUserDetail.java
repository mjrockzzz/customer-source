package com.ge.customerbillingportal.common.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ge.customerbillingportal.entity.AdminAccount;

import java.util.Collection;


/**
 * @author Nitin K.
 * Class containing methods to set and get user name and password and account status
 */
public class TadalinUserDetail extends AdminAccount implements UserDetails {

    private static final long serialVersionUID = 1L;

	public TadalinUserDetail(AdminAccount account, Collection<? extends GrantedAuthority> authorities) {

        super.setId(account.getId());
        super.setAdminName(account.getAdminName());
        super.setOriginPassword(account.getPassword());
        super.setStatus(account.getStatus());
        super.setCreateDate(account.getCreateDate());
        super.setModifyDate(account.getModifyDate());

        this.authorities = authorities;
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getAdminName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

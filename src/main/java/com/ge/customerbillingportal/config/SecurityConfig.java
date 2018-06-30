package com.ge.customerbillingportal.config;

import com.ge.customerbillingportal.common.security.TadalinUserDetailService;
import com.ge.customerbillingportal.util.EncoderUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.client.OAuth2RestOperations;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;

import java.util.Arrays;

/**
 * @author Nitin K.
 * Configuration class to enables Spring Security global methods for security customization
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(-1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TadalinUserDetailService tadalinUserDetailService;

    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;

    @Autowired
    private Environment environment;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/rest/**", "/api/**", "/**")
                .and()
                .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        if (isProfileActive("test")) {
            inMemoryConfigurer().withUser("testaccount").password("testaccount").authorities("ROLE_TEST").and().configure(auth);
        }

        auth.authenticationProvider(daoAuthenticationProvider);
    }


    private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryConfigurer() {
        return new InMemoryUserDetailsManagerConfigurer<>();
    }


    //    @Autowired
    //   protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.userDetailsService(mzUserDetailService).passwordEncoder(EncoderUtil.pwdEncoder);
    //    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider impl = new DaoAuthenticationProvider();
        impl.setUserDetailsService(tadalinUserDetailService);
        impl.setPasswordEncoder(EncoderUtil.pwdEncoder);
        impl.setHideUserNotFoundExceptions(false) ;
        return impl ;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Judging the parameters profile is it active Profile 
	 * in, recommended Use ApplicationContextRegister in the method
     * Note: Do not set any Profile 
     * time, ActiveProfile will be empty, 
     * but actually will use DefaultProfile
     */
    @Deprecated
    private Boolean isProfileActive (String testProfile) {

        if(environment.getActiveProfiles().length > 0) {
            return Arrays.asList(environment.getActiveProfiles()).stream()
                    .filter(x -> x.equalsIgnoreCase(testProfile)).findFirst().isPresent();
        }

        else if(environment.getDefaultProfiles().length > 0) {
            return Arrays.asList(environment.getDefaultProfiles()).stream()
                    .filter(x -> x.equalsIgnoreCase(testProfile)).findFirst().isPresent();
        }
        else {
            return false;
        }
    }

}

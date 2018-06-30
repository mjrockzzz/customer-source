package com.ge.customerbillingportal.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nitin K.
 * Conponent class to register ApplicationContext.
 */
@Component
public class ApplicationContextRegister implements ApplicationContextAware, EnvironmentAware {

    private static Logger LOG = LoggerFactory.getLogger(ApplicationContextRegister.class);

    private static ApplicationContext applicationContext = null;

    private static Environment environment = null;

    private static Set<String> activeProfiles = new HashSet<>();


    @Override
    public void setApplicationContext(ApplicationContext app) throws BeansException {
        applicationContext = app;
        LOG.warn("ContextRegister has set the ApplicationContext normally");
    }

    @Override
    public void setEnvironment(Environment env) {
        environment = env;

        if(env.getActiveProfiles().length > 0) {
            for(String profile : env.getActiveProfiles()) {
                activeProfiles.add(profile);
            }
        }

        else if(env.getDefaultProfiles().length > 0) {
            for(String profile : env.getDefaultProfiles()) {
                activeProfiles.add(profile);
            }
        }

        LOG.warn("ContextRegister has set Environment normally");
    }


    /**
     * Determine whether to activate one Profile
     * @param profile
     * @return
     */
    public static boolean isProfileActive(String profile) {
        return activeProfiles.contains(profile);
    }
}

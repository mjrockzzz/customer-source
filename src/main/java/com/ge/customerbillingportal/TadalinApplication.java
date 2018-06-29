package com.ge.customerbillingportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/*@SpringBootApplication
public class TadalinApplication {

	public static void main(String[] args) {
		SpringApplication.run(TadalinApplication.class, args);
	}*/

@SpringBootApplication
public class TadalinApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TadalinApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TadalinApplication.class, args);
	}

}
package com.samsoft.crm.mongo.test;

import org.jfairy.Fairy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import com.samsoft.crm.api.CustomerProfileService;

//@SpringApplicationConfiguration(classes = { CustomerServiceConfiguration.class })
@EnableAutoConfiguration
@TestExecutionListeners(inheritListeners = false, listeners = { DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class })
public class CustomerProfileTest extends AbstractTestNGSpringContextTests {

	private static final Fairy JFAIRY = Fairy.create();

	private static final int COUNT = 2000;

	@Autowired
	private CustomerProfileService customerService;

	public void init() {
		Assert.assertNotNull(customerService);
	}

}

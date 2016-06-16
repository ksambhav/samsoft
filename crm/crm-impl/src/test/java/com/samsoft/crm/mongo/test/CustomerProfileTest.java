package com.samsoft.crm.mongo.test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.samsoft.crm.api.CustomerProfileService;
import com.samsoft.crm.mongo.CustomerServiceConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CustomerServiceConfiguration.class })
public class CustomerProfileTest {

	@Autowired
	private CustomerProfileService customerService;

	@Before
	public void init() {
		Assert.assertNotNull(customerService);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

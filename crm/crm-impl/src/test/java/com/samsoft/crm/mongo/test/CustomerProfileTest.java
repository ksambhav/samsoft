package com.samsoft.crm.mongo.test;

import java.util.ArrayList;
import java.util.List;

import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.samsoft.crm.api.CustomerProfileService;
import com.samsoft.crm.domain.CustomerProfile;
import com.samsoft.crm.mongo.CustomerServiceConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CustomerServiceConfiguration.class })
@EnableAutoConfiguration
public class CustomerProfileTest {

	private static final Fairy JFAIRY = Fairy.create();

	private static int COUNT = 2000;

	@Autowired
	private CustomerProfileService customerService;

	@Before
	public void init() {
		Assert.assertNotNull(customerService);
	}

	@Test
	public void testSaveMany() {
		List<CustomerProfile> customers = new ArrayList<>(COUNT);

		for (int i = 0; i < COUNT; i++) {
			CustomerProfile profile = new CustomerProfile();

			Person person = JFAIRY.person();
			profile.setAddress(person.getAddress().toString());
			profile.setFullName(person.fullName());
			profile.setMobile(person.telephoneNumber());
			profile.setTenant("test");
			customers.add(profile);
		}

		customerService.save(customers);
	}

}

/**
 * 
 */
package com.samsoft.crm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsoft.crm.api.CustomerProfileService;
import com.samsoft.crm.domain.CustomerProfile;

/**
 * @author Kumar Sambhav Jain
 *
 */
@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = { "http://localhost" }, maxAge = 3600)
public class CustomerController {

	@Autowired
	protected CustomerProfileService customerService;

	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public Page<CustomerProfile> list(Pageable pageRequest) {
		return customerService.findAll(pageRequest);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/find/:id")
	public CustomerProfile list(@PathVariable("id") String id) {
		return customerService.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/save")
	public CustomerProfile save(CustomerProfile profile, BindingResult br) {
		if (br.hasErrors()) {
			throw new RuntimeException(br.toString());
		}
		return customerService.save(profile);

	}

	@RequestMapping(method = RequestMethod.GET, path = "/search")
	public List<CustomerProfile> search(@RequestParam String name) {
		return customerService.textSearchByName(name);
	}
}

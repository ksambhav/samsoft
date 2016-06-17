/**
 * 
 */
package com.samsoft.crm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = {"http://localhost"}, maxAge = 3600)
public class CustomerController {

	@Autowired
	protected CustomerProfileService customerService;
	
	@RequestMapping(method=RequestMethod.GET,path="/list")
	public List<CustomerProfile> list(){
		return customerService.findAll();
	}
	
	
	@RequestMapping(method=RequestMethod.GET,path="/search")
	public List<CustomerProfile> search(@RequestParam String name){
		return customerService.textSearchByName(name);
	}
}

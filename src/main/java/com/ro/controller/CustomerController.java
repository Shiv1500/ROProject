package com.ro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ro.dto.CustomerRequest;
import com.ro.dto.CustomerResponse;
import com.ro.service.CustomerService;
@RestController
public class CustomerController {
	@Autowired	
	private CustomerService  customerService;

	@GetMapping(value = "/getAllCustomer")
	public List<CustomerResponse> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@PostMapping(value = "/saveCustomer")
	public Integer saveCustomer(@RequestBody CustomerRequest customerRequest) {
		return customerService.saveCustomer(customerRequest);
	}

	@GetMapping(value = "/getCustomerByCustId/{customerId}")
	public CustomerResponse getCustomerById(@PathVariable("customerId") String customerId) {
		return customerService.getCustomerByCustId(customerId);
	}

	@PutMapping(value = "/updateCustomer")
	public Integer updateCustomer(@RequestBody CustomerRequest CustomerRequest) {
		return customerService.updateCustomer(CustomerRequest);
	}

	@DeleteMapping(value = "/deleteCustomer/{customerId")
	public Integer deleteCustomer(@PathVariable("customerId") String customerId) {
		return customerService.deleteCustomer(customerId);
	}

}

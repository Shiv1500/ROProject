package com.ro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ro.dto.CustomerRequest;
import com.ro.dto.CustomerResponse;
@Service
public interface CustomerService {
	public Integer saveCustomer(CustomerRequest  customerRequest );
	public Integer deleteCustomer(String customerID );
	public Integer updateCustomer(CustomerRequest customerRequest);
	public CustomerResponse getCustomerByCustId(String customerId);
	public List<CustomerResponse> getAllCustomer();
}

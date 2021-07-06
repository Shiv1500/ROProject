package com.ro.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ro.dto.AddressResponse;
import com.ro.dto.CustomerRequest;
import com.ro.dto.CustomerResponse;
import com.ro.entity.Address;
import com.ro.entity.Customer;
import com.ro.repository.CustomerRepository;
@Component
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Integer saveCustomer(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		Address address = new Address();
		List<Address> list = new ArrayList<Address>();
		BeanUtils.copyProperties(customerRequest, customer);
		BeanUtils.copyProperties(customerRequest.getAddressRequest(), address);
		list.add(address);
		customer.setAddress(list);
		customerRepository.save(customer);
		return customer.getId();
	}

	@Override
	public Integer deleteCustomer(String customerdId) {
		return customerRepository.deleteCustomerByCustId(customerdId);
	}

	@Override
	public Integer updateCustomer(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		Address address = new Address();
		List<Address> list = new ArrayList<Address>();
		BeanUtils.copyProperties(customerRequest, customer);
		BeanUtils.copyProperties(customerRequest.getAddressRequest(), address);
		list.add(address);
		customer.setAddress(list);
		customerRepository.save(customer);
		return customer.getId();
	}

	@Override
	public CustomerResponse getCustomerByCustId(String customerId) {
		CustomerResponse customerResponse = new CustomerResponse();
		Customer customer = customerRepository.findCustomersByCustId(customerId);
		AddressResponse addressResponse = new AddressResponse();
		BeanUtils.copyProperties(customer, customerResponse);
		List<Address> address = customer.getAddress();
		address.forEach(addr ->{
			addressResponse.setAddressId(addr.getAddressId());
			addressResponse.setCustId(addr.getCustId());
			addressResponse.setFlatNo(addr.getFlatNo());
			addressResponse.setLandmark(addr.getLandmark());
			addressResponse.setLatitude(addr.getLatitude());
			addressResponse.setLognitude(addr.getLognitude());
			addressResponse.setPincode(addr.getPincode());
			addressResponse.setState(addr.getState());
		});
		customerResponse.setAddressResponse(addressResponse);
		return customerResponse;
	}

	@Override
	public List<CustomerResponse> getAllCustomer() {
		Iterable<Customer> customerData = customerRepository.findAll();
		ArrayList<CustomerResponse> customerList = new ArrayList<CustomerResponse>();
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerData, customer);
		customerData.forEach(c ->{
			CustomerResponse customerResponse = new CustomerResponse();
			AddressResponse addressResponse = new AddressResponse();
			customerResponse.setId(c.getId());
			customerResponse.setCustomerId(c.getCustomerId());
			customerResponse.setCustomerName(c.getCustomerName());
			customerResponse.setMobileNumber(c.getMobileNumber());
			customerResponse.setAlternateMobileNumber(c.getAlternateMobileNumber());
			customerResponse.setMobileNumber(c.getModel());
			customerResponse.setCharge(c.getCharge());
			customerResponse.setServiceType(c.getServiceType());
			customerResponse.setModel(c.getModel());
			customerResponse.setEmail(c.getEmail());
			List<Address> address = c.getAddress();
			address.forEach(addr ->{
				addressResponse.setAddressId(addr.getAddressId());
				addressResponse.setCustId(addr.getCustId());
				addressResponse.setFlatNo(addr.getFlatNo());
				addressResponse.setLandmark(addr.getLandmark());
				addressResponse.setLatitude(addr.getLatitude());
				addressResponse.setLognitude(addr.getLognitude());
				addressResponse.setPincode(addr.getPincode());
				addressResponse.setState(addr.getState());
			});
			customerResponse.setAddressResponse(addressResponse);
			customerList.add(customerResponse);
		});
		return customerList;
	}

}

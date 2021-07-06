package com.ro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ro.dto.PaymentModeDto;
import com.ro.service.PaymentModeService;

@RestController
public class PaymentModeController {
	@Autowired
	private PaymentModeService paymentModeService;
	
	@GetMapping(value = "/getPaymentMode")
	public List<PaymentModeDto>  getPaymentModeData(){
		return paymentModeService.findAllPaymentModeData();
		
	}
	
	@PostMapping(value = "/savePaymentMode")
	public String savePaymentMode(@RequestBody PaymentModeDto paymentModeDto){
		paymentModeService.savePaymentModeData(paymentModeDto);
		return "data save suceessfully";
		
	}
	
	@PutMapping
	public String deletePaymentMode(@RequestBody PaymentModeDto paymentModeDto){
		paymentModeService.deletePaymentModeData(paymentModeDto);
		return "data delete suceessfully";
		
	}

}

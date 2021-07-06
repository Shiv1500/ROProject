package com.ro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ro.dto.PaymentModeDto;
import com.ro.entity.PaymentMode;
import com.ro.repository.PaymentModeRepository;

@Component
public class PaymentModeServiceImpl  implements PaymentModeService{
	@Autowired
	private PaymentMode paymentMode;
	@Autowired
	private PaymentModeRepository  paymentModeRepository;
	

	@Override
	public void savePaymentModeData(PaymentModeDto paymentModeDto) {
		paymentMode.setPaymentModeId(paymentModeDto.getPaymentModeId());
		paymentMode.setPaymentModeName(paymentModeDto.getPaymentModeName());
	 	paymentModeRepository.save(paymentMode);
	}

	@Override
	public String updatePaymentModeData(PaymentModeDto paymentModeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePaymentModeData(PaymentModeDto paymentModeDto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PaymentModeDto> findAllPaymentModeData() {
		ArrayList<PaymentModeDto> ListpayModeDto = new ArrayList<PaymentModeDto>();
		PaymentModeDto paymentModeDto = new PaymentModeDto();
		Iterable<PaymentMode> findAll = paymentModeRepository.findAll();
		findAll.forEach(payMode ->  {
			paymentModeDto.setPaymentModeId(payMode.getPaymentModeId());
			paymentModeDto.setPaymentModeName(payMode.getPaymentModeName());
			ListpayModeDto.add(paymentModeDto);
		});
		return ListpayModeDto;
	}
}

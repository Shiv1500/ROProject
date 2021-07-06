package com.ro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ro.dto.PaymentModeDto;

@Service
public interface PaymentModeService {
	public void savePaymentModeData(PaymentModeDto paymentModeDto);
	public String updatePaymentModeData(PaymentModeDto paymentModeDto);
	public String deletePaymentModeData(PaymentModeDto paymentModeDto);
	public List<PaymentModeDto> findAllPaymentModeData();
}

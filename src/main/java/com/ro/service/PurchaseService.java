package com.ro.service;

import org.springframework.stereotype.Service;

import com.ro.dto.PurchaseDTO;

@Service
public interface PurchaseService {
public PurchaseDTO savePurchaseData(PurchaseDTO purchaseDTO) throws Exception;
}

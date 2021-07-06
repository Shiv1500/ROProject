package com.ro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ro.dto.PurchaseDTO;
import com.ro.service.PurchaseService;

@RestController
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseController;

	@PostMapping("/savePurchaseData")
	public ResponseEntity<PurchaseDTO> saveData(@RequestBody PurchaseDTO purchaseDTO) throws Exception {
		PurchaseDTO savePurchaseData = null;
		try {
			savePurchaseData = purchaseController.savePurchaseData(purchaseDTO);
		} catch (Exception e) {
			throw e; 
		}
		System.out.println("exit into saveData()");
		return new ResponseEntity<PurchaseDTO>(savePurchaseData,HttpStatus.OK);
	}

}

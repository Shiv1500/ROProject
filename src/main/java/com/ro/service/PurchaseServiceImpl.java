package com.ro.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ro.dto.CustomerResponse;
import com.ro.dto.ProductRequest;
import com.ro.dto.PurchaseDTO;
import com.ro.entity.Customer;
import com.ro.entity.Purchase;
import com.ro.entity.PurchaseHistory;
import com.ro.exception.DelightRoException;
import com.ro.repository.CustomerRepository;
import com.ro.repository.PurchaseHistoryRepository;
import com.ro.repository.PurchaseRepository;

@Component
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PurchaseHistoryRepository purchaseHistoryRepository;
	@Override
	public PurchaseDTO savePurchaseData(PurchaseDTO purchaseDTO) throws Exception {
		int custId = 0;
		if(purchaseDTO.getPurchaseRequest()!=null && purchaseDTO.getCustomerRequest()!=null && purchaseDTO.getProductRequest()!=null) {
			try {
				Purchase purchase = new Purchase();
				Customer customer = new Customer();
				CustomerResponse customerResponse = new CustomerResponse();
				Random rand = new Random();
				BeanUtils.copyProperties(purchaseDTO.getPurchaseRequest(), purchase);
				BeanUtils.copyProperties(purchaseDTO.getCustomerRequest(), customer);
				customer.setCustomerId(rand.nextInt(10000)+"");
				custId = customerRepository.save(customer).getId();
				System.out.println("custId-->"+custId);
				Integer pruchaseId = purchaseRepository.save(purchase).getPruchaseId();
				System.out.println("pruchaseId-->"+pruchaseId);
				List<ProductRequest> productpurchased = purchaseDTO.getProductRequest();
				if(null != productpurchased) {
					for (ProductRequest productRequest : productpurchased) {
						PurchaseHistory purchaseHistory = new PurchaseHistory();
						purchaseHistory.setCustId(custId);
						purchaseHistory.setProductId(productRequest.getProductId());
						purchaseHistory.setPurchaseQty(productRequest.getQuantity());
						purchaseHistory.setPurchaseId(pruchaseId);
						purchaseHistoryRepository.save(purchaseHistory);
					}
					
					BeanUtils.copyProperties(purchaseDTO.getCustomerRequest(), customerResponse);
					customerResponse.setId(custId);
					purchaseDTO.setCustomerResponse(customerResponse);
				}else {
					throw new DelightRoException("Data not saved ");
				}
			}catch(Exception exp) {
				throw exp;
			}
		}else {
			throw new Exception();
		}
		/*productpurchased.forEach(prd ->{
			purchaseHistory.setCustId(custId);
			purchaseHistory.setProductId(prd.getProductId());
			purchaseHistory.setPurchaseQty(prd.getQuantity());
			purchaseHistory.setPurchaseId(pruchaseId);
			purchaseHistoryRepository.save(purchaseHistory);
		});*/
		return purchaseDTO;
	}

}

package com.ro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ro.dto.CustomerResponse;
import com.ro.dto.ProductRequest;
import com.ro.dto.ProductResponse;
import com.ro.dto.PurchaseDTO;
import com.ro.dto.PurchaseResponse;
import com.ro.entity.Customer;
import com.ro.entity.Purchase;
import com.ro.entity.PurchaseHistory;
import com.ro.repository.CustomerRepository;
import com.ro.repository.ProductRepository;
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
	@Autowired
	private ProductRepository productRepository;

	@Override
	public PurchaseDTO savePurchaseData(PurchaseDTO purchaseDTO) throws Exception {

		if(purchaseDTO.getPurchaseRequest()!=null && purchaseDTO.getCustomerRequest()!=null && purchaseDTO.getProductRequest()!=null) {
			try {
				Purchase purchase = new Purchase();
				Customer customer = new Customer();
				Customer customerInfo = null;
				CustomerResponse customerResponse = new CustomerResponse();
				Random rand = new Random();
				BeanUtils.copyProperties(purchaseDTO.getPurchaseRequest(), purchase);
				BeanUtils.copyProperties(purchaseDTO.getCustomerRequest(), customer);
				customer.setCustomerId(rand.nextInt(10000)+"");
				customerInfo = customerRepository.save(customer);
				Integer pruchaseId = purchaseRepository.save(purchase).getPruchaseId();
				List<ProductRequest> productpurchased = purchaseDTO.getProductRequest();
				if(null != productpurchased) {
					for (ProductRequest productRequest : productpurchased) {
						PurchaseHistory purchaseHistory = new PurchaseHistory();
						int warrantyDays = productRepository.findWarrantyDaysById(productRequest.getProductId());
						purchaseHistory.setCustId(customerInfo.getId());
						purchaseHistory.setProductId(productRequest.getProductId());
						purchaseHistory.setPurchaseQty(productRequest.getQuantity());
						purchaseHistory.setPurchaseId(pruchaseId);
						purchaseHistory.setProductWarrantyDays(warrantyDays);
						Date warrantyExpiryDate = preapreWarrantyExpiryDate(warrantyDays);
						purchaseHistory.setWarrantyExpiryDate(warrantyExpiryDate);
						purchaseHistoryRepository.save(purchaseHistory);
					}

					BeanUtils.copyProperties(customerInfo, customerResponse);
					purchaseDTO.setCustomerResponse(customerResponse);
				}else {
					throw new Exception();
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
		return this.prepareFinalResponse(purchaseDTO);
	}

	public Date preapreWarrantyExpiryDate(Integer warrantyDays) {
		Date parse = null;
		if(warrantyDays > 0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			//Adding warrantyDays to the current date
			cal.add(Calendar.DAY_OF_MONTH, warrantyDays);  
			String newDate = sdf.format(cal.getTime());  
			try {
				parse = sdf.parse(newDate);
			} catch (ParseException e) {

				e.printStackTrace();
			}
		}
		return parse;

	}

	public PurchaseDTO  prepareFinalResponse(PurchaseDTO purchaseDtoReq) {
		PurchaseDTO purchaseDtoRes = new PurchaseDTO();
		PurchaseResponse purchaseResponse = new PurchaseResponse();
		ArrayList<ProductResponse> productList = null;
		List<ProductRequest> productpurchased = purchaseDtoReq.getProductRequest();
		if(null != productpurchased) {
			for (ProductRequest productRequest : productpurchased) {
				productList = new ArrayList<ProductResponse>();
				ProductResponse productResponse = new ProductResponse();
				productResponse.setProductId(productRequest.getProductId());
				productResponse.setQuantity(productRequest.getQuantity());
				productResponse.setSellingPrice(productRequest.getSellingPrice());
				productList.add(productResponse);
			}
		}
		purchaseDtoRes.setProductResponse(productList);
		purchaseResponse.setPruchaseDate(purchaseDtoReq.getPurchaseRequest().getPruchaseDate());
		purchaseResponse.setPruchaseAmount(purchaseDtoReq.getPurchaseRequest().getPruchaseAmount());
		purchaseDtoRes.setPurchaseResponse(purchaseResponse);
		purchaseDtoRes.setCustomerResponse(purchaseDtoReq.getCustomerResponse());
		return purchaseDtoRes;
	}

	@Override
	public Boolean checkWarranty(int custId,String productId) throws Exception {
		
	 java.sql.Date warrantyExpiryDate = purchaseHistoryRepository.findWarrantyExpiryDate(custId,productId);
		System.out.println();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	      Date d1 = sdformat.parse("2019-04-15");//current Date
	      Date d2 = sdformat.parse("2019-08-10");//warrantyExpiryDate
	      System.out.println("The date 1 is: " + sdformat.format(d1));
	      System.out.println("The date 2 is: " + sdformat.format(d2));
	      if(d1.compareTo(d2) > 0) {
	         System.out.println("Date 1 occurs after Date 2");
	         return false;
	      } else if(d1.compareTo(d2) < 0) {
	         System.out.println("Date 1 occurs before Date 2");
	         return true;
	      } else if(d1.compareTo(d2) == 0) {
	         System.out.println("Both dates are equal");
	         return true;
	      }
	   
		return Boolean.TRUE;
	}
	
}

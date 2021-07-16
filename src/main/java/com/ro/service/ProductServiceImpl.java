package com.ro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ro.dto.ProductRequest;
import com.ro.dto.ProductResponse;
import com.ro.entity.Product;
import com.ro.repository.ProductRepository;
@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductResponse saveProduct(ProductRequest productRequest) throws Exception {
		ProductResponse productResponse = new ProductResponse();
			try {
				Product product = productRepository.save(this.prepareProductSaveData(productRequest));
				BeanUtils.copyProperties(product, productResponse);
			}catch(Exception exception) {
				throw new  Exception();
			}
		return productResponse ;

	}

	@Override
	public List<ProductResponse> findAllProduct() {
		Iterable<Product> findAll = productRepository.findAll();
		return prepareProductReponse(findAll);
	}
	private Product prepareProductSaveData(ProductRequest ProductRequest) {
		Product product = new Product();
		product.setProductId(ProductRequest.getProductId());
		product.setProductName(ProductRequest.getProductName());
		product.setProductDiscription(ProductRequest.getProductDiscription()); 
		product.setWarrantyDays(ProductRequest.getWarrantyDays()) ;
		product.setWarrantyApplicable(ProductRequest.getWarrantyApplicable());
		product.setManufactureDate(ProductRequest.getManufactureDate()); 
		product.setPurchasePrice(ProductRequest.getPurchasePrice()); 
		product.setSellingPrice(ProductRequest.getSellingPrice()); 
		product.setDiscount(ProductRequest.getDiscount()) ;
		product.setQuantity(ProductRequest.getQuantity());
		return product;

	}

	private List<ProductResponse> prepareProductReponse(Iterable<Product> findAll){
		List<ProductResponse> productList = new ArrayList<ProductResponse>();
		findAll.forEach(p ->{
			ProductResponse ProductResponse = new ProductResponse();
			ProductResponse.setProductId(p.getProductId());
			ProductResponse.setProductName(p.getProductName());
			ProductResponse.setProductDiscription(p.getProductDiscription());
			ProductResponse.setManufactureDate(p.getManufactureDate());
			ProductResponse.setWarrantyDays(p.getWarrantyDays());
			ProductResponse.setWarrantyApplicable(p.getWarrantyApplicable());
			ProductResponse.setSellingPrice(p.getSellingPrice());
			ProductResponse.setPurchasePrice(p.getPurchasePrice());
			ProductResponse.setDiscount(p.getDiscount());
			ProductResponse.setQuantity(p.getQuantity());

			productList.add(ProductResponse);
		});
		return productList;
	}

	@Override
	public List<ProductResponse> findProductById(String producId) {
		List<Product> productlist = productRepository.findProductById(producId);
		return prepareProductReponse(productlist);
	}

	@Override
	public List<ProductResponse> findProductByName(String producName) {
		List<Product> productlist = productRepository.findProductByName(producName);
		return prepareProductReponse(productlist);
	}

	private List<ProductResponse> prepareProductReponse(List<Product> productlist){
		ProductResponse ProductResponse = new ProductResponse();
		List<ProductResponse> productList = new ArrayList<ProductResponse>();
		productlist.forEach(p ->{
			ProductResponse.setProductId(p.getProductId());
			ProductResponse.setProductName(p.getProductName());
			ProductResponse.setProductDiscription(p.getProductDiscription());
			ProductResponse.setManufactureDate(p.getManufactureDate());
			ProductResponse.setWarrantyDays(p.getWarrantyDays());
			ProductResponse.setWarrantyApplicable(p.getWarrantyApplicable());
			ProductResponse.setSellingPrice(p.getSellingPrice());
			ProductResponse.setPurchasePrice(p.getPurchasePrice());
			ProductResponse.setDiscount(p.getDiscount());
			ProductResponse.setQuantity(p.getQuantity());

			productList.add(ProductResponse);
		});
		return productList;
	}

	@Override
	public Integer updateProduct(ProductRequest productRequest) {
		/*
		 * List<Product> prodtList =
		 * productRepository.findProductById(productRequest.getProductId());
		 * if(prodtList !=null && !prodtList.isEmpty()) { Product product =
		 * prodtList.get(0); Product productSaveData =
		 * prepareProductSaveData(productRequest);
		 * productSaveData.setId(product.getId()); Product updateProduct =
		 * productRepository.save(productSaveData); return updateProduct.getId(); }
		 */		return 0;
	}

	@Override
	public Integer deleteProduct(String producId) {
		//		List<Product> prodtList = productRepository.findProductById(producId);
		//		if(prodtList !=null && !prodtList.isEmpty()) {
		//			Product product = prodtList.get(0);
		//			productRepository.deleteById(product.getId());
		//			return 1;
		//		}
		return 0;
	}

}

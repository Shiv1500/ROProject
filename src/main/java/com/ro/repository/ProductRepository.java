package com.ro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ro.entity.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	@Query(value = "SELECT * from product_details_tbl p WHERE p.product_id = :productId", nativeQuery = true)
	public List<Product> findProductById(@Param("productId") String productId);
	@Query(value = "SELECT * from product_details_tbl p WHERE p.product_Name " +  " like concat('%',:productName,'%')", nativeQuery = true)
	public List<Product> findProductByName(@Param("productName") String productName);
	@Query(value ="select warranty_days from product_details_tbl where product_id = :productId", nativeQuery = true)
	public Integer findWarrantyDaysById(@Param("productId") String productId);
}

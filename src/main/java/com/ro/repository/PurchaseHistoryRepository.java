package com.ro.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ro.entity.PurchaseHistory;
@Repository
public interface PurchaseHistoryRepository extends CrudRepository<PurchaseHistory, Integer> {

@Query(value="select warranty_expiry_date from purchase_history_tbl where cust_id = :custId and product_id = :productId", nativeQuery = true)
public Date findWarrantyExpiryDate(@Param("custId") Integer custId,@Param("productId") String productId);

}

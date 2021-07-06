package com.ro.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ro.entity.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	@Query(value = "select * from customer_details_tbl c where c.customer_id  = :customerId ", nativeQuery = true)
	public Customer findCustomersByCustId(@Param("customerId") String customerId);
	
	@Query(value = "delete from customer_details_tbl c where c.customer_id = :customerId ", nativeQuery = true)
    public Integer deleteCustomerByCustId(@Param("customerId") String customerId);
	
}

package com.ro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ro.entity.Purchase;
@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {

}

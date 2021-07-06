package com.ro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ro.entity.PurchaseHistory;
@Repository
public interface PurchaseHistoryRepository extends CrudRepository<PurchaseHistory, Integer> {

}

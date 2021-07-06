package com.ro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ro.entity.PaymentMode;

@Repository
public interface PaymentModeRepository  extends CrudRepository<PaymentMode, Integer>{

}

package com.ro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ro.entity.Address;
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}

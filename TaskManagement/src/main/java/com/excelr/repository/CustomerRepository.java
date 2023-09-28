package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByEmail(String email);

	String deleteByEmail(String email);

	boolean existsByEmail(String email);


}

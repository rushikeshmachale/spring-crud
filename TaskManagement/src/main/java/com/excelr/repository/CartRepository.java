package com.excelr.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{


	List<Cart> findByCustomerId(int id);

	Cart deleteBycustomerId(int customerId);

}

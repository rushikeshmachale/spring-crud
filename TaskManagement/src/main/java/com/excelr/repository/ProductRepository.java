package com.excelr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{

	Products findProductById(int id);



}

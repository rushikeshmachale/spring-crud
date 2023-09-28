package com.excelr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

	boolean existsByCustomerId(int customerId);

	List<Orders> findByCustomerId(int customerId);

	Orders deleteByCustomerId(int customerId);

	boolean existsByPid(int pid);

	Orders deleteByPid(int pid);

	List<Orders> findAllByCustomerId(int customerId);

	boolean existsByOrderId(int orderId);

	Optional<Orders> findByOrderId(int orderId);

	Orders getByOrderId(int orderId);



}

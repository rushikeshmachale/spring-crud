package com.excelr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Orders;
import com.excelr.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
@CrossOrigin("http://localhost:3000")
public class OrderController {

	@Autowired
	OrderRepository repo;
	
	@PostMapping("/add")
	public Orders addOrder(@RequestBody Orders orders) {
		return repo.save(orders);
	}
	
	@GetMapping("/get")
	public List<Orders> getAllOrders(){
		return repo.findAll();
	}
	

	
	@GetMapping("/findbyid/{orderId}")
	public Optional<Orders> getByOrderId(@PathVariable int orderId) {
		Optional<Orders> o=null;
		if(repo.existsByOrderId(orderId)) {
			o= repo.findByOrderId(orderId);
		}else {
			System.out.println("order not found");
		}
		return o;
	}
	@GetMapping("/find/{customerId}")
	public List<Orders> getByCustomerId(@PathVariable int customerId) {
		List<Orders> o=null;
		if(repo.existsByCustomerId(customerId)) {
			o= repo.findByCustomerId(customerId);
		}else {
			System.out.println("customer not found");
		}
		return o;
	}
	
	@PutMapping("/update/{orderId}")
	public Orders updateOrders(@RequestBody Orders orders,@PathVariable int orderId) {
		Orders o = new Orders();
		if(repo.existsByOrderId(orderId)) {
			o.setOrderId(orderId);
			o.setPid(orders.getPid());
			o.setCustomerId(orders.getCustomerId());
			o.setNumbers(repo.getByOrderId(orders.getOrderId()).getNumbers());
			o.setName(orders.getName());
			
			o.setPrice(orders.getPrice());
			o.setStatus(orders.getStatus());
			repo.save(o);
		}
		
		return o;
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<String> deleteByCustomerId(@PathVariable int customerId){
		if(repo.existsByCustomerId(customerId)) {
			repo.deleteByCustomerId(customerId);
			return new ResponseEntity<String>("orders deleted succes",HttpStatus.OK);
		}
		return new ResponseEntity<String>("customer not found",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete/customer/{pid}")
	public ResponseEntity<String> deletebYProductId(@PathVariable int pid){
		if(repo.existsByPid(pid)) {
			repo.deleteByPid(pid);
			return new ResponseEntity<String>("orders deleted success",HttpStatus.OK);
		}
		return new ResponseEntity<String>("product not found",HttpStatus.BAD_REQUEST);
	}
}

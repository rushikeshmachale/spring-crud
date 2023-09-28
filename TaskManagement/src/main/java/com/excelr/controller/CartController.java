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

import com.excelr.entity.Cart;
import com.excelr.repository.CartRepository;

@RestController
@RequestMapping("/cart")
@CrossOrigin("http://localhost:3000")
public class CartController {

	@Autowired
	CartRepository repo;
	
//	@PostMapping("/addcart")
//	public List<Cart> addCart(@RequestBody List<Cart> cart) {
//		return repo.saveAll(cart);
//	}
	
	@PostMapping("/add")
	public Cart addCart(@RequestBody Cart cart) {
		return repo.save(cart);
	}
	
	@GetMapping("/getcart")
	public List<Cart> getCart() {
		return repo.findAll();
	}
	
	@GetMapping("/get/{customerId}")
	public List<Cart> getCustomerCart(@PathVariable int customerId) {
		List<Cart> c=null;
		if(repo.findById(customerId) != null) {
			c=repo.findByCustomerId(customerId);
			
		}
		return c;
	}
	
//	@GetMapping("/getbycust/{pid}")
//	public Optional<Cart> getByCustomer(@PathVariable int customerId,@PathVariable int pid){
//		if(repo.existsById(customerId)) {
//			
//			return repo.findById(pid);
//		}
//		return null;
//	}
	
	@DeleteMapping("/delete/{pid}")
	public String deleteCart(@PathVariable int pid) {
		repo.deleteById(pid);
		return "cart element deleted";
				
	}
}

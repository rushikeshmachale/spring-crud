package com.excelr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Products;
import com.excelr.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {

	@Autowired
	ProductRepository repo;
	
	@GetMapping("/getproduct")
	public List<Products> getProduct(){
		return repo.findAll();
	}
	
	@PostMapping("/addproduct")
	public Products addProduct(@RequestBody Products products) {
		return repo.save(products);
	}

	@GetMapping("/get/{id}")
	public Products getProductId(@PathVariable int id) {
		return repo.findProductById(id);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return new ResponseEntity<String>("product deleted",HttpStatus.OK);
		}
		return new ResponseEntity<String>("product not found",HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody Products products, @PathVariable int id) {
		if(repo.existsById(id)) {
			Products p = new Products();
			p.setId(id);
			p.setName(products.getName());
			p.setCatagory(products.getCatagory());
			p.setRatings(products.getRatings());
			p.setSpecification(products.getSpecification());
			p.setPrice(products.getPrice());
			repo.save(p);
			return new ResponseEntity<String>("Product updated success",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Product not found",HttpStatus.BAD_REQUEST);
		}

	}
}

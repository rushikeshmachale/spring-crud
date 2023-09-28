package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Customer;
import com.excelr.repository.CustomerRepository;
import com.excelr.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/customers")
@CrossOrigin("http://localhost:3000")
public class CustomerController {

	@Autowired
	CustomerRepository repo;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Customer employee) {
		if(repo.findByEmail(employee.getEmail())!=null) {
			return new ResponseEntity<String>("Customer already exists",HttpStatus.BAD_REQUEST);
		}else {
			repo.save(employee);
		}
		return new ResponseEntity<String>("Customer added successful",HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public List<Customer> getAll(){
		return repo.findAll();
	}
	
	@GetMapping("/find/{email}")
	public Customer get(@PathVariable String email){
		return repo.findByEmail(email);
	}
	
	@PutMapping("/update/{email}")
	public ResponseEntity<String> update(@PathVariable String email,@RequestBody Customer employee) {
		if(repo.findByEmail(email)!=null) {
			Customer e = new Customer();
			e.setId(employee.getId());
			e.setEmail(email);
			e.setName(employee.getName());
			e.setPassword(employee.getPassword());
			repo.save(e);
			return  new ResponseEntity<String>("Employee updated successful",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer e){
		if(repo.findByEmail(e.getEmail())!=null) {
			if(e.getPassword().equals(repo.findByEmail(e.getEmail()).getPassword())) {
				return new ResponseEntity<String>("Employee login successfully",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Invalid credentials",HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);
	}
}

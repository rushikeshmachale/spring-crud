package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Admin;
import com.excelr.repository.AdminRepository;



@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {

	@Autowired
	AdminRepository repo;
	
	@PostMapping("/add")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
		if(repo.findByEmail(admin.getEmail())!=null) {
			return new ResponseEntity<String>("admin already exists",HttpStatus.OK);
		}else {
			repo.save(admin);
			return new ResponseEntity<String>("admin added success",HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> adminLogin(@RequestBody Admin admin){
		if(repo.findByEmail(admin.getEmail())!=null) {
			if(admin.getPassword().equals(repo.findByEmail(admin.getEmail()).getPassword())) {
				return new ResponseEntity<String>("admin login success",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Invalid credentials",HttpStatus.BAD_REQUEST);
			}
		}
		
		return new ResponseEntity<String>("User not found",HttpStatus.BAD_REQUEST);
	}
}

package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.excelr.entity.Customer;
import com.excelr.repository.CustomerRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	CustomerRepository repo;
	
	@Override
	public ResponseEntity<String> addEmployee(Customer employee) {
		if(repo.findByEmail(employee.getEmail())!=null) {
			return new ResponseEntity<String>("Employee already exists",HttpStatus.BAD_REQUEST);
		}else {
			repo.save(employee);
		}
		return new ResponseEntity<String>("Employee added successful",HttpStatus.OK);
	}

	@Override
	public List<Customer> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Customer getEmployee(String email) {
			return repo.findByEmail(email);
	}

	@Override
	public ResponseEntity<String> update(String email,Customer employee) {
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

	@Override
	public ResponseEntity<String> deleteEmployee(String email) {
		if(repo.existsByEmail(email)) {
			repo.deleteByEmail(email);
			return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> login(Customer emp) {
		if(repo.findByEmail(emp.getEmail())!=null) {
			if(emp.getPassword().equals(repo.findByEmail(emp.getEmail()).getPassword())) {
				return new ResponseEntity<String>("Employee login successfully",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Invalid credentials",HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);
	}
	
}

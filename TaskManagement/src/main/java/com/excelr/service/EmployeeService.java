package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.excelr.entity.Customer;
import com.excelr.repository.CustomerRepository;

@Service
public interface EmployeeService {

	public ResponseEntity<String> addEmployee(Customer employee);
	public List<Customer> getAllEmployee();
	public Customer getEmployee(String email);
	public ResponseEntity<String> update(String email,Customer employee);
	ResponseEntity<String> deleteEmployee(String email);
	ResponseEntity<String> login(Customer emp);
	
}

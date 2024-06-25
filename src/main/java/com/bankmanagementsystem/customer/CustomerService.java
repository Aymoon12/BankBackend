package com.bankmanagementsystem.customer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
	private final CustomerRespository customerRespository;

	@Autowired
	public CustomerService(CustomerRespository customerRespository) {
		this.customerRespository = customerRespository;
	}

	public void saveCustomer(Customer customer) {
		Optional<Customer> cusUser = customerRespository.findByUserName(customer.getUserName());
		Optional<Customer> cusEmail = customerRespository.findByEmail(customer.getEmail());
		if(cusUser.isPresent()){
			throw new IllegalStateException("Username is already used!");
		}
		else if(cusEmail.isPresent()){
			throw new IllegalStateException("Email is already used!");
		}
		customerRespository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRespository.findAll();
	}

	public Customer login(String userName, String password) {
		if(userName == null || userName.isEmpty() || password == null || password.isEmpty()){
			throw new IllegalStateException("Username and password are required!");
		}
		Customer cusUser = customerRespository.findByUserName(userName).orElse(null);
		if(cusUser == null){
			return null;
		}
		if (!cusUser.getPassword().equals(password)) {
			return null;
		}
		return cusUser;
	}

	@Transactional
	public void updatePassword(String userName, String newPassword) {
		if(userName == null || userName.isEmpty() || newPassword == null || newPassword.isEmpty()){
			throw new IllegalStateException("Username and password are required!");
		}
		Customer c = customerRespository.findByUserName(userName).orElse(null);
		if(c == null){
			throw new IllegalStateException("Username not found!");
		}
		c.setPassword(newPassword);
	}


	public Customer findCustomer(String username){
		Customer c =  customerRespository.findByUserName(username).orElse(null);
		if(c == null){
			throw new IllegalStateException("Username not found!");
		}
		return c;
	}


}

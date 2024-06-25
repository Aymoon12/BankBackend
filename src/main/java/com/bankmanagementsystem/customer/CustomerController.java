package com.bankmanagementsystem.customer;

import com.bankmanagementsystem.Login.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import com.bankmanagementsystem.Login.LoginRequest;
import com.bankmanagementsystem.Exceptions.LoginExceptions;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/bank")
@CrossOrigin
public class CustomerController {

	@Autowired
	private final CustomerService customerService;
	private final CustomerRespository customerRespository;

	@Autowired
	public CustomerController(CustomerService customerService, CustomerRespository customerRespository) {
		this.customerService = customerService;
		this.customerRespository = customerRespository;
	}

	@PostMapping("/add")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
		customerService.saveCustomer(customer);
		return new ResponseEntity<>("Customer added successfully", HttpStatus.CREATED);
	}

	@PostMapping("/getAll")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}

	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody LoginRequest loginRequest) {
		Customer c = customerService.login(loginRequest.getUserName(), loginRequest.getPassword());
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
	}

	@GetMapping("/checkUser")
	public ResponseEntity<Customer> checkUser(@RequestParam String username) {
		return new ResponseEntity<>(customerService.findCustomer(username),HttpStatus.OK);
	}

	@PutMapping("/updatePass")
	public ResponseEntity<Boolean> updateCustomer(@RequestParam String userName ,
												  @RequestParam String newPass){
		customerService.updatePassword(userName,newPass);
		return new ResponseEntity<>(true,HttpStatus.ACCEPTED);

	}



}

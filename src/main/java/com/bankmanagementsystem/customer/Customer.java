package com.bankmanagementsystem.customer;


import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;




@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;

	@Column(nullable=false)
	private String userName;

	@Column(name="password",nullable=false)
	private String password;


	@Column(name = "name",nullable=false)
	private String name;


	@Column(name ="email",nullable=false)
	private String email;


	@Column(name="phone_number",nullable=false)
	private String phone_number;


	@Column(name="date_of_birth",nullable=false)
	private LocalDate dob;


	@Column(name = "address",nullable=false)
	private String address;

	@CreationTimestamp
	@Column(name = "created_at",nullable = false,updatable = false)
	private LocalDateTime created_at;
//
//	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Account> accounts = new ArrayList<>();


	@UpdateTimestamp
	private LocalDateTime updated_at;


	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}



	public Customer() {

	}

	public Customer(String name, String email, String phone_number, String address, LocalDate dob, String userName, String password){
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.dob = dob;
		this.userName = userName;
		this.password = password;

	}


	//	public List<Account> getAccounts() {
//		return accounts;
//	}


	public int getCustomer_id() {
		return customer_id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", phone_number='" + phone_number + '\'' +
				", dob=" + dob +
				", address='" + address + '\'' +
				'}';
	}
}





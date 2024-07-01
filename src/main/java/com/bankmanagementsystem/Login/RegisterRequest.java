package com.bankmanagementsystem.Login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	private String name;
	private String email;
	private String phone_number;
	private String address;
	private LocalDate dob;
	private String password;
	private String username;

}

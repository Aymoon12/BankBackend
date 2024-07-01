package com.bankmanagementsystem.Login;

import lombok.*;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	// Getters and Setters
	private String username;
	private String password;

}
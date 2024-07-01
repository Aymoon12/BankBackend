package com.bankmanagementsystem.Authentication.auth;

import brave.Response;
import com.bankmanagementsystem.Login.LoginRequest;
import com.bankmanagementsystem.Login.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
		return ResponseEntity.ok(service.register(registerRequest));
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody LoginRequest loginRequest){
		return ResponseEntity.ok(service.authenticate(loginRequest));

	}


}

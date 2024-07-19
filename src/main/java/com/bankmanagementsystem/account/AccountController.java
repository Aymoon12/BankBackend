package com.bankmanagementsystem.account;

import brave.Response;
import com.bankmanagementsystem.Requests.AccountRegistrationRequest;
import com.bankmanagementsystem.Requests.DeleteRequest;
import com.bankmanagementsystem.Requests.MoneyHandlingRequest;
import com.bankmanagementsystem.Requests.TransferRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/v1/account")
public class AccountController {

	@Autowired
	private final AccountRepository accountRepository;
	private final AccountService accountService;

	@PostMapping("/addAccount")
	public ResponseEntity<Account> addAccount(@RequestBody AccountRegistrationRequest accountRegistrationRequest){
		return ResponseEntity.ok(accountService.addAccount(accountRegistrationRequest));
	}

	@PostMapping("/deposit")
	public ResponseEntity<String> deposit(@RequestBody MoneyHandlingRequest mhr){
		return ResponseEntity.ok(accountService.deposit(mhr));
	}

	@PostMapping("/withdraw")
	public ResponseEntity<String> withdraw(@RequestBody MoneyHandlingRequest mhr){
		return ResponseEntity.ok(accountService.withdraw(mhr));
	}

	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<Account> delete(@PathVariable("id") int account_number){
		return ResponseEntity.ok(accountService.delete(account_number));
	}






}

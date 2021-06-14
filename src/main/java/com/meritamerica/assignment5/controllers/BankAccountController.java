package com.meritamerica.assignment5.controllers;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.model.CheckingAccount;
import com.meritamerica.assignment5.model.MeritBank;

@RestController
public class BankAccountController {
	
	@PostMapping(value = "/account")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@RequestBody @Valid CheckingAccount checkingAccount) {
		Arrays.asList(MeritBank.getAccountHolders()).get(id-1).addCheckingAccount(checkingAccount);
		return checkingAccounts;
	}

}

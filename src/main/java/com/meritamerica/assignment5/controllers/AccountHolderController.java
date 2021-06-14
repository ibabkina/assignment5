package com.meritamerica.assignment5.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.exceptions.NoSuchResourceFoundException;
import com.meritamerica.assignment5.exceptions.NotFoundException;
import com.meritamerica.assignment5.model.AccountHolder;
import com.meritamerica.assignment5.model.CheckingAccount;
import com.meritamerica.assignment5.model.MeritBank;

@RestController
public class AccountHolderController {
	
//	List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
	
	
	
//	@GetMapping(value = "/AccountHolder/{id}")
//	public AccountHolder getAccountHolderById(@PathVariable("id") long id) throws NotFoundException {
//		AccountHolder accountHolder = MeritBank.getAccountHolder(id);
//		if(accountHolder == null) { 
//			logs.warn("No account exists"); 
//			throw new NotFoundException("Account Not Found"); 
//		}
//		return accountHolder;
//	}
//	
	
	
	
//	@GetMapping(value = "/accountHolders/{id}")
//	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
//	public AccountHolder getAccountHolderById(@PathVariable int id) throws NoSuchResourceFoundException {
//		if(id > MeritBank.getAccountHolders().length) {
//			throw new NoSuchResourceFoundException("Invalid id");
//		}
//		return (MeritBank.getAccountHolders)[id-1]; 
//	}
	
	
	@PostMapping(value = "/accountHolder/{id}/checkingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingToAccountHolder(@PathVariable long id, @RequestBody CheckingAccount checkingAccount) 
			throws NotFoundException {
		AccountHolder accountHolder = MeritBank.getAccountHolder(id);
		accountHolder.addCheckingAccount(checkingAccount);
		return checkingAccount;
	}
	
	// TODO complete
	@GetMapping(value = "/accountHolder/{id}/checkingAccounts")
	public CheckingAccount[] getAccountHolderCheckingAccounts(@PathVariable long id) 
			throws NotFoundException {
		AccountHolder accountHolder = this.getAccountHolderById(id);
		return accountHolder.getCheckingAccounts();
	}
	
	
	@GetMapping(value = "/accountHolders")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public List<AccountHolder> getAccountHolders(){
		return Arrays.asList(MeritBank.getAccountHolders());
	}
	
	@GetMapping(value = "/accountHolders/{id}")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public AccountHolder getAccountHolderById(@PathVariable long id) throws NotFoundException {
		AccountHolder accountHolder = MeritBank.getAccountHolder(id);
		if(accountHolder == null) { 
			//logger.warn("No account exists"); 
			throw new NotFoundException("Account Not Found"); 
		}
		return accountHolder;
	}

//	/customers/{customerId}/accounts/{accountId}
}

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
import com.meritamerica.assignment5.model.AccountHolder;
import com.meritamerica.assignment5.model.CheckingAccount;
import com.meritamerica.assignment5.model.MeritBank;

@RestController
public class AccountHolderController {
	
//	List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
	
	@GetMapping(value = "/accountHolders")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public List<AccountHolder> getAccountHolders(){
		return Arrays.asList(MeritBank.getAccountHolders());
	}
	
	@GetMapping(value = "/accountHolders/{id}")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public AccountHolder getAccountHolderById(@PathVariable int id) throws NoSuchResourceFoundException {
		if(id > Arrays.asList(MeritBank.getAccountHolders()).size()) {
			throw new NoSuchResourceFoundException("Invalid id");
		}
		return Arrays.asList(MeritBank.getAccountHolders()).get(id-1); 
	}
	
//	@GetMapping(value = "/accountHolders/{id}")
//	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
//	public AccountHolder getAccountHolderById(@PathVariable int id) throws NoSuchResourceFoundException {
//		if(id > MeritBank.getAccountHolders().length) {
//			throw new NoSuchResourceFoundException("Invalid id");
//		}
//		return (MeritBank.getAccountHolders)[id-1]; 
//	}
	
	@PostMapping(value = "/accountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		MeritBank.addAccountHolder(accountHolder);
		return accountHolder;
	}
	
	@PostMapping(value = "/accountHolders/{id}/checkingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@PathVariable("id") long id, @RequestBody @Valid CheckingAccount checkingAccount) 
	{
		AccountHolder[] accHolders = MeritBank.getAccountHolders();		
		accHolders[id].addCheckingAccount(checkingAccount);
		return checkingAccount;
	}
	
	@PostMapping(value = "/AccountHolder/{id}/CheckingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingToAccountHolder(@PathVariable("id") long id, @RequestBody CheckingAccount checkingAccount) throws NotFoundException, ExceedsCombinedBalanceLimitException, ExceedsFraudSuspicionLimitException {
		AccountHolder ah = this.getAccountHolderById(id);
		ah.addCheckingAccount(checkingAccount);
		return checkingAccount;
	}
	
	// TODO complete
	@GetMapping(value = "/AccountHolder/{id}/CheckingAccount")
	public CheckingAccount[] getAccountHolderCheckingAccounts(@PathVariable("id") long id) throws NotFoundException {
		AccountHolder ah = this.getAccountHolderById(id);
		return ah.getCheckingAccounts();
	}

//	/customers/{customerId}/accounts/{accountId}
}

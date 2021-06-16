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

import com.meritamerica.assignment5.exceptions.ExceedsFraudSuspicionLimitException;
import com.meritamerica.assignment5.exceptions.NoSuchResourceFoundException;
import com.meritamerica.assignment5.exceptions.NotFoundException;
import com.meritamerica.assignment5.model.AccountHolder;
import com.meritamerica.assignment5.model.CDAccount;
import com.meritamerica.assignment5.model.CDOffering;
import com.meritamerica.assignment5.model.CheckingAccount;
import com.meritamerica.assignment5.model.MeritBank;
import com.meritamerica.assignment5.model.SavingsAccount;

@RestController
public class AccountHolderController {
	
//	List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
	
//	@GetMapping(value = "/accountHolders")
//	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
//	public List<AccountHolder> getAccountHolders(){
//		
//		return Arrays.asList(MeritBank.getAccountHolders());
//	}
	
	@PostMapping(value = "/accountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		
		MeritBank.addAccountHolder(accountHolder);
		return accountHolder;
	}
	
	@GetMapping(value = "/accountHolders")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public AccountHolder[] getAccountHolders(){
		
		return MeritBank.getAccountHolders();
	}
	
	@GetMapping(value = "/accountHolders/{customerId}")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public AccountHolder getAccountHolderById(@PathVariable long customerId) 
			throws NotFoundException {
		
		AccountHolder accountHolder = MeritBank.getAccountHolder(customerId);	
		if(accountHolder == null) { throw new NotFoundException("AccountHolder Not Found"); }
		return accountHolder;
	}
	
	@PostMapping(value = "/accountHolders/{customerId}/checkingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAcc(@PathVariable long customerId, 
			@RequestBody @Valid CheckingAccount checkingAccount) 
			throws NotFoundException {
			
		AccountHolder accountHolder = this.getAccountHolderById(customerId);
		if(accountHolder == null) { throw new NotFoundException("AccountHolder Not Found"); }
		System.out.println(checkingAccount.toString());
		accountHolder.addCheckingAccount(checkingAccount);
		return checkingAccount;
	}
	
	@GetMapping(value = "/accountHolders/{customerId}/checkingAccounts")
	@ResponseStatus(HttpStatus.OK) 
	public CheckingAccount[] getAccHolderCheckingAccounts(@PathVariable long customerId) 
			throws NotFoundException {
			
		AccountHolder accountHolder = this.getAccountHolderById(customerId); 
		CheckingAccount[] checkingAccounts = accountHolder.getCheckingAccounts();
		if(checkingAccounts.length <= 0l) { throw new NotFoundException("Checking Accounts Not Found"); }
		return checkingAccounts;
	}
	
//	@GetMapping(value = "/accountHolders/{customerId}/CheckingAccounts/{accountId")
//	@ResponseStatus(HttpStatus.OK) 
//	public CheckingAccount getAccHolderCheckingAccount(@PathVariable long customerId,
//			@PathVariable long accountId) {
//		
//		CheckingAccount[] checkingAccounts = this.getAccHolderCheckingAccounts(customerId);
//		return checkingAccounts.
//		
//	}
	
	@PostMapping(value = "/accountHolders/{customerId}/savingsAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAcc(@PathVariable long customerId, 
			@RequestBody @Valid SavingsAccount savingsAccount) 
			throws NotFoundException {
			
		AccountHolder accountHolder = this.getAccountHolderById(customerId);
		if(accountHolder == null) { throw new NotFoundException("AccountHolder Not Found"); }
		System.out.println(savingsAccount.toString());
		accountHolder.addSavingsAccount(savingsAccount);
		return savingsAccount;
	}
	
	@GetMapping(value = "/accountHolders/{customerId}/savingsAccounts")
	@ResponseStatus(HttpStatus.OK) 
	public SavingsAccount[] getAccHolderSavingsAccounts(@PathVariable long customerId) 
			throws NotFoundException {
			
		AccountHolder accountHolder = this.getAccountHolderById(customerId); 
		SavingsAccount[] savingsAccounts = accountHolder.getSavingsAccounts();
		if(savingsAccounts.length <= 0l) { throw new NotFoundException("Savings Accounts Not Found"); }
		return savingsAccounts;
	}
	
	@PostMapping(value = "/accountHolders/{customerId}/cdAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAcc(@PathVariable long customerId, 
			@RequestBody @Valid CDAccount cdAccount) 
			throws NotFoundException {
			
		AccountHolder accountHolder = this.getAccountHolderById(customerId);
		if(accountHolder == null) { throw new NotFoundException("AccountHolder Not Found"); }
		System.out.println(cdAccount.toString());
		accountHolder.addCDAccount(cdAccount);
		return cdAccount;
	}
	
	@PostMapping(value = "/accountHolders/{customerId}/cdAccount/{cdOfferingId}")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccWithCDOffering(@PathVariable long customerId, @PathVariable int cdOfferingId,
			double openingBalance) 
			throws NotFoundException, ExceedsFraudSuspicionLimitException {
			
		AccountHolder accountHolder = this.getAccountHolderById(customerId);
		if(accountHolder == null) { throw new NotFoundException("AccountHolder Not Found"); }
		CDOffering cdOffering = MeritBank.getCDOffering(cdOfferingId);
		if(cdOffering == null) { throw new NotFoundException("CD Offering Not Found"); }
		CDAccount cdAccount = accountHolder.addCDAccount(cdOffering, openingBalance);
//		System.out.println(cdAccount.toString());
		return cdAccount;
	}
	
	@GetMapping(value = "/accountHolders/{customerId}/cdAccounts")
	@ResponseStatus(HttpStatus.OK) 
	public CDAccount[] getAccHolderCDAccounts(@PathVariable long customerId) 
			throws NotFoundException {
			
		AccountHolder accountHolder = this.getAccountHolderById(customerId); 
		CDAccount[] cdAccounts = accountHolder.getCDAccounts();
		if(cdAccounts.length <= 0l) { throw new NotFoundException("CD Accounts Not Found"); }
		return cdAccounts;
	}
	
	
	
	

//	/customers/{customerId}/accounts/{accountId}
}

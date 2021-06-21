package com.meritamerica.assignment5.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.MeritAmericaBankApplication;
import com.meritamerica.assignment5.exceptions.NoSuchResourceFoundException;
import com.meritamerica.assignment5.exceptions.NotExistException;
import com.meritamerica.assignment5.exceptions.NotFoundException;
import com.meritamerica.assignment5.model.AccountHolder;
import com.meritamerica.assignment5.model.BankAccount;
import com.meritamerica.assignment5.model.CDOffering;
import com.meritamerica.assignment5.model.MeritBank;
import com.meritamerica.assignment5.model.Post;

@RestController
public class MeritBankController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String greetMe() {
		return "<html><h2>Welcome to Merit Bank Assignment 5</h2></html>"; 
	}

	@GetMapping(value = "/cdOfferings")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public CDOffering[] getCDOfferings() { // throws NotFoundException {
		CDOffering[] cdOfferings = MeritBank.getCDOfferings();
//		if(cdOfferings == null) { throw new NotFoundException("Offerings Not Found"); }
		return cdOfferings;  
	}
	
	@GetMapping(value = "/cdOfferings/{cdOfferingId}")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public CDOffering getCDOfferingById(@PathVariable int cdOfferingId) throws NotFoundException {
		CDOffering cdOffering = MeritBank.getCDOffering(cdOfferingId);
//		if(cdOfferings == null) { throw new NotFoundException("Offerings Not Found"); }
		return cdOffering;  
	}
	
	@PostMapping(value = "/cdOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody @Valid CDOffering cdOffering) {
		MeritBank.addCDOffering(cdOffering);  
		return cdOffering;
	}
	
	@GetMapping(value = "/bankAccounts/{accountId")
	@ResponseStatus(HttpStatus.OK) 
	public BankAccount getAccount(@PathVariable long customerId,
			@PathVariable long accountId) {
		return MeritBank.getBankAccount(accountId);	
	}
	
//	List<String> strings = new ArrayList<String>();
//	List<Post> posts = new ArrayList<Post>();
//	
//	
//	@GetMapping(value = "/strings")
//	public List<String> getStrings() {
//		return strings;
//	}
//	
//	@PostMapping(value = "/strings")
//	public String addString(@RequestBody String string) {
////		String string = "test";
//		strings.add(string);
//		return string;
//	}
//
//	@GetMapping(value = "/posts")
//	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
//	public List<Post> getPosts(){
//		return posts;
//	}
//	
//	@PostMapping(value = "/posts")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Post addPost(@RequestBody @Valid Post post) {
//		posts.add(post);
//		return post;
//	}
//	
//	@GetMapping(value = "/posts/{id}") //Spring notation to designate a url parameter {} or a path variable
//	public Post getPostById(@PathVariable int id) throws NoSuchResourceFoundException {
//		if(id > posts.size()-1) {
//			throw new NoSuchResourceFoundException("Invalid id");
//		}
//		return posts.get(id);
//		
//	}
	
}

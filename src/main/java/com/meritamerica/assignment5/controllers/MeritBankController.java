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
import com.meritamerica.assignment5.model.MeritBank;
import com.meritamerica.assignment5.model.Post;

@RestController
public class MeritBankController {
	
	Logger logger = LoggerFactory.getLogger(MeritAmericaBankApplication.class);
	
	@GetMapping(value = "/accountHolders")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public List<AccountHolder> getAccountHolders(){
		return Arrays.asList(MeritBank.getAccountHolders());
	}
	
	@GetMapping(value = "/accountHolders/{id}")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public AccountHolder getAccountHolderById(@PathVariable long id) {
		
		AccountHolder accountHolder = null;
		
		try {
			
			accountHolder = MeritBank.getAccountHolder(id);	
		
		} catch (NotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			logger.warn("No accountHolder exists");
			e.printStackTrace();
		}
		return accountHolder;
	}
	
	@PostMapping(value = "/accountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		MeritBank.addAccountHolder(accountHolder);
		return accountHolder;
	}
	
	
	
//	List<String> strings = new ArrayList<String>();
//	List<Post> posts = new ArrayList<Post>();
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String test() {
//		return "hello world";
//	}
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

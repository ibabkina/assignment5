package com.meritamerica.assignment5.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.model.CDOffering;
import com.meritamerica.assignment5.model.MeritBank;

@RestController
public class CDOfferingController {

	List<CDOffering> cdOfferings = new ArrayList<CDOffering>();
	
	
	@GetMapping(value = "/cdOfferings")
	@ResponseStatus(HttpStatus.OK) //Redundant but can do if your team prefers
	public List<CDOffering> getCDOfferings(){
		return MeritBank.getCDOfferings();   // return Arrays.asList(MeritBank.getCDOfferings());
	}
	
	@PostMapping(value = "/cdOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody @Valid CDOffering cdOffering) {
		
	
//		if(cdOffering.getInterestRate() <= 0 || cdOffering.getInterestRate() >= 1 || cdOffering.getTerm() <= 0) {
//			throw new MissingFieldException("term or interestRate not within bounds"); }
		cdOfferings.add(cdOffering);
		MeritBank.setCDOfferings(cdOfferings);  // (CDOffering)cdOfferings.toArray());
		return cdOffering;
	}
	
}

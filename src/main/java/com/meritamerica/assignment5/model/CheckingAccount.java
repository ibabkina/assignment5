package com.meritamerica.assignment5.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This program creates a checking account for a client.
 * 
 * @author Irina Babkina 
 * 
 */

public class CheckingAccount extends BankAccount {
	
	private double interestRate = 0.0001;
	
	/**
	 * Default constructor 
	 */
	public CheckingAccount() { super(0, 0.0001); }
	
	/**
	 * @param openingBalance
	 */
	public CheckingAccount(double openingBalance){
		super(openingBalance, 0.0001);
	}
	
	/**
	 * @param openingBalance
	 * @param interestRate
	 */
	public CheckingAccount(double openingBalance, double interestRate){
		super(openingBalance, interestRate);
	}
	
	/**
	 * @param accNumber
	 * @param openingBalance
	 * @param interestRate
	 */
	public CheckingAccount(long accNumber, double openingBalance, double interestRate, java.util.Date accountOpenedOn){
		super(accNumber, openingBalance, interestRate, accountOpenedOn);
	}
	
	// Should throw a java.lang.NumberFormatException if String cannot be correctly parsed
	public static CheckingAccount readFromString(String accountData) 
			throws NumberFormatException, ParseException {
		String[] args = accountData.split(",");
		CheckingAccount acc = new CheckingAccount(Long.parseLong(args[0]), Double.parseDouble(args[1]), 
		Double.parseDouble(args[2]), new SimpleDateFormat("MM/dd/yyyy").parse(args[3]));
		return acc;
		}
	
//	/**
//	 * @return the interestRate
//	 */
//	public double getInterestRate() { return this.interestRate; }
//	
//	/**
//	 * Calculates the future value of the account balance based on the interest 
//	 * and number of years
//	 * @param years: number of periods in years
//	 * @return the future value
//	 */
//	double futureValue(int years){ return this.balance * pow(1 + interestRate, years); }

	@Override
	public String toString() {
		return "\nChecking Account Number: " + this.getAccountNumber()
			+ "\nChecking Account Balance: $" + String.format("%.2f", this.getBalance())
			+ "\nChecking Account Interest Rate: " + String.format("%.4f", this.getInterestRate())
			+ "\nChecking Account Balance in 3 years: " + String.format("%.2f", this.futureValue(3))
			+ "\nChecking Account Opened Date " + this.getOpenedOn();
	}
}
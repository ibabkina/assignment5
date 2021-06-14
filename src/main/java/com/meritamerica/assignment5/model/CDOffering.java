package com.meritamerica.assignment5.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Range;


/**
 * This program creates CD offerings for a bank.
 * 
 * @author Irina Babkina 
 * 
 */

public class CDOffering {
	
	static int nextId = 1;
	int id;
	
	@Positive(message = "Term must be positive")
	@Range(min=1, message = "Term must be 1 or more years")
	private Integer term;
	
	@Positive(message = "Interest Rate must be positive")
	@Range(min=0, max=1, message = "Interest Rate must be between 0 and 1")
	private Double interestRate;
	
//	/**
//	 * Default constructor 
//	 */
//	public CDOffering(){
//		this.id = nextId++;
//		this.term = 0;
//		this.interestRate = 0.0;
//	}
	
	/**
	 * @param term
	 * @param interestRate
	 */
	public CDOffering(int term, double interestRate){
		this.id = nextId++;
		this.term = term;
		this.interestRate = interestRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Doesn't Throw a java.lang.NumberFormatException if String cannot be correctly parsed
	// because of test cases (the test cases files are not in the try/catch block)
	public static CDOffering readFromString(String cdOfferingDataString) {
		String[] args = cdOfferingDataString.split(",");
		CDOffering offering = new CDOffering(Integer.parseInt(args[0]), Double.parseDouble(args[1]));
		return offering;
		}

	/**
	 * @return the term
	 */
	public int getTerm() { return term; }

	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) { this.term = term; }

	/**
	 * @return the interestRate
	 */
	public double getInterestRate() { return interestRate; }

	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
	
	@Override
	public String toString() {
		return "\nCD Offering Term : " + this.getTerm()+ "\nCD Offering Rate : " + this.getInterestRate();
		}
	
	public String writeToString() {
		return Integer.toString(this.getTerm()) + "," 
				+ Double.toString(this.getInterestRate()); 
	}
}
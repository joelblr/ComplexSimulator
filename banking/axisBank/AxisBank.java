package banking.axisBank;

import banking.*;

import java.util.*;
public class AxisBank implements Bank {

	// Use "sc" Scanner to get the input;  ie,  sc.nextLine();
	//"sc" is initialised in Bank Interface

	/*
	 Credential1, Credential2, Credential3,...
	 u can add ur own, but make sure to differ it from one bank to another 
	 */
	String name, phno;
	double amount;

	AxisBank() {
		amount = 0.0;
	}


	/*This method needs to create a new account for the user;
	 * So, accept all the Axis-Account Credentials like name, phno....
	 and these credentials differ from a bank to another.
	
	** Ur given a Linked-List of axis-bank-accounts, <it may be empty> ,
	 just  get the credentials and create a new instance of AxisBank*/
	public static void createAccount(HashMap<String, AxisBank> accList) {
		

	}

	/*This method needs to delete an existing account;
	 * So, accept Credentials like name and phno <to verify>, then
	 check if that name exists, then verify if phno is correct: finally remove that instance<ie, account>
	 else "throw IllegalAccessException"

	** Ur given a Linked-List of axis-bank-accounts, <it may be empty> ,
	 just  get the credentials and remove that existing instance of AxisBank*/
	public static void deleteAccount(HashMap<String, AxisBank> accList) throws IllegalAccessException {
		

	}

	/*This method needs to switch an existing account with another;
	 * So, accept Credentials like name and phno <to verify>, then
	 check if that name exists, then verify if phno is correct:
	 		finally set "currentAcc" with the instance<ie, account> that user wants
	 else "throw IllegalAccessException"

	** Ur given a Linked-List of axis-bank-accounts, <it may be empty> ,
	 just  get the credentials and remove that existing instance of AxisBank
	 Finally: return the switchedAcc*/
	public static AxisBank switchAccount(HashMap<String, AxisBank> accList) throws IllegalAccessException {
		//it should contain the instance of the account that the user wants to switch to
		//Dont do:  Bank switchedAcc = new Bank();
		//Dont create a new Account but instead assign it with an existing one,
				//else "throw IllegalAccessException"
		AxisBank switchedAcc;///////////////

		System.out.println("YOU ARE SWITCHING WITH UR CURRENT ACCOUNT*");

		System.out.print("ENTER ACC-NAME: ");
		String name = sc.nextLine();

		System.out.print("ENTER ACC-PHNO: ");
		String phno = sc.nextLine();

		//checking if name exists
		if (accList.containsKey(name)) {
			if (phno == (accList.get(name)).phno) {
				switchedAcc = accList.get(name);
				return switchedAcc;
			}
		}
		//Throwing an Illegal...Exception
		throw new IllegalAccessException();
	}


	/*This Method displays the Simple/Compound Interest (ur choice)
	based on the principal, rate of I, and time period
	
	Simple */
	public static void loanInterest(Bank acc) {
		

	}

	/*This Method displays Current Balance of the account.
	Simple*/
	public static void amountBalance(Bank acc) {
		

	}

	/*This Method accepts the amount the user wants to deposit in account acc
	update the amount
	 throw "UnsupportedOperationException" if amt is not valid, ie, negative.

	Simple*/
	public static void amountDeposit(Bank acc) throws UnsupportedOperationException {
		

	}

	/*This Method accepts the amount the user wants to withdraw in account acc
	update the amount
	 throw "UnsupportedOperationException" if amt is not valid, ie, negative or if overflow cases.

	Simple*/
	public static void amountWithdraw(Bank acc) throws UnsupportedOperationException {
		

	}


}

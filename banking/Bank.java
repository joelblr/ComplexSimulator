package banking;

import java.util.*;

import javax.security.auth.login.AccountNotFoundException;

public interface Bank {

	public static void createAccount(LinkedList<Bank> accList) {
		
	}
	public static void deleteAccount(LinkedList<Bank> accList) throws AccountNotFoundException {
		
	}
	public static void switchAccount(LinkedList<Bank> accList) throws AccountNotFoundException {
		
	}


	public static void loanInterest(Bank acc) {
		
	}
	public static void amountBalance(Bank acc) {
		
	}
	public static void amountDeposit(Bank acc) throws UnsupportedOperationException {
		
	}
	public static void amountWithdraw(Bank acc) throws UnsupportedOperationException {
		
	}

}

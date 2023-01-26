package banking;

import java.util.*;

import javax.security.auth.login.AccountNotFoundException;

public interface Bank {

	Scanner sc = new Scanner(System.in);

	public static void createAccount(HashMap<String, Bank> accList) {
	
	}
	public static void deleteAccount(HashMap<String, Bank> accList) throws AccountNotFoundException {

	}
	public static Bank switchAccount(HashMap<String, Bank> accList) throws AccountNotFoundException {
		return accList.get("bank");//just a return statement, dont worry much, it'll be overridden.
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
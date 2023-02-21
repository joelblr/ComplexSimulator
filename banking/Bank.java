package banking;

import java.util.*;

import javax.security.auth.login.AccountNotFoundException;

public interface Bank {

	Scanner sc = new Scanner(System.in);

	//something like sign-up
	public static void createAccount(HashMap<String, Bank> accList) {
	
	}
	public void deleteAccount(HashMap<String, Bank> accList) throws AccountNotFoundException {

	}
	//something like log-out
	public Bank switchAccount(HashMap<String, Bank> accList) throws AccountNotFoundException {
		return accList.get("bank");//just a return statement, dont worry much, it'll be overridden.
	}


	public void loanInterest(Bank acc) {
		
	}
	public void amountBalance(Bank acc) {
		
	}
	public void amountDeposit(Bank acc) throws UnsupportedOperationException {
		
	}
	public void amountWithdraw(Bank acc) throws UnsupportedOperationException {
		
	}

}

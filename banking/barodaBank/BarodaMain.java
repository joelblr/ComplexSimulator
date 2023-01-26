package banking.barodaBank;

import banking.*;

import java.util.*;
public class BarodaMain extends BankMain {

	static BarodaBank currentBarodaAcc;
	static HashMap<String, BarodaBank> barodaAccounts;
	
	static {
		currentBarodaAcc = null;
	}


	public static void setMenu() {
		menuWidth = 20 + 11; title = "Baroda Bank";
		menu.clear();
		menu.add("Quit Baroda-Bank");
		menu.add("Create an Account");
		menu.add("Delete an Account");
		menu.add("Switch an Account");
		menu.add("Find Loan-Interest");
		menu.add("Find Amount-Balance");
		menu.add("Find Amount-Deposit");
		menu.add("Find Amount-Withdraw");
	}


	public static void run() {
		BarodaRun();
	}


	public static void BarodaRun() {

		currentBarodaAcc = null;
		while (true) {

			try {

				clearScreen();
				if (errorFlag) {
					showErrorMessage(errorMsg);
					errorFlag = false;
				}
				setMenu();	showMenu();
				loadingProcess();

				switch (getChoice) {

					case 1 :
						BarodaBank.createAccount(barodaAccounts);
						break;
	
					case 2 :
						BarodaBank.deleteAccount(barodaAccounts);
						break;

					case 3 :
						BarodaBank.switchAccount(barodaAccounts);
						break;

					case 4 :
						BarodaBank.loanInterest(currentBarodaAcc);
						break;

					case 5 :
						BarodaBank.amountBalance(currentBarodaAcc);
						break;
	
					case 6 :
						BarodaBank.amountDeposit(currentBarodaAcc);
						break;

					case 7 :
						BarodaBank.amountWithdraw(currentBarodaAcc);
						break;

					case 0 :
						return;

					default :
						errorMsg = "<INVALID CHOICE!>";  errorFlag = true;
						throw new NumberFormatException();

				}continueProcess();

			}catch (InputMismatchException | NumberFormatException e) {
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;

			}catch (IllegalAccessException e) {
				errorMsg = "<Account Expired!>";	errorFlag = true;

			}catch (UnsupportedOperationException e) {
				errorMsg = "<Not Enough Money!>";	errorFlag = true;

			}catch(Exception e) {
				errorMsg = "<HEY!>";	errorFlag = true;

			}

		}
	}
}

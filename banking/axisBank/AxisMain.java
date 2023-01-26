package banking.axisBank;

import banking.*;
import java.util.*;
public class AxisMain extends BankMain {

	static AxisBank currentAxisAcc;
	static HashMap<String, AxisBank> axisAccounts;

	static {
		currentAxisAcc = null;
		axisAccounts = new HashMap<String, AxisBank>();
	}


	public static void setMenu() {
		menuWidth = 20 + 11; title = "Axis Bank";
		menu.clear();
		menu.add("Quit Axis-Bank");
		menu.add("Create an Account");
		menu.add("Delete an Account");
		menu.add("Switch an Account");
		menu.add("Find Loan-Interest");
		menu.add("Find Amount-Balance");
		menu.add("Find Amount-Deposit");
		menu.add("Find Amount-Withdraw");
	}


	public static void run() {
		AxisRun();
	}


	public static void AxisRun() {

		currentAxisAcc = null;
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
						AxisBank.createAccount(axisAccounts);
						break;
	
					case 2 :
						AxisBank.deleteAccount(axisAccounts);
						break;

					case 3 :
						currentAxisAcc = AxisBank.switchAccount(axisAccounts);
						break;

					case 4 :
						AxisBank.loanInterest(currentAxisAcc);
						break;

					case 5 :
						AxisBank.amountBalance(currentAxisAcc);
						break;
	
					case 6 :
						AxisBank.amountDeposit(currentAxisAcc);
						break;

					case 7 :
						AxisBank.amountWithdraw(currentAxisAcc);
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

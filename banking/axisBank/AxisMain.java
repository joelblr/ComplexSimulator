package banking.axisBank;

import banking.*;
import design.Design;

import java.util.*;
public class AxisMain extends BankMain {

	static AxisBank currentAxisAcc;
	static HashMap<String, AxisBank> axisAccounts;

	static {
		currentAxisAcc = null;
		axisAccounts = new HashMap<String, AxisBank>();
	}


	public static void showMenu() {

		List<String> stdin = 
				Design.printBox(
					"Axis Bank", "",
					" *1*  Create an Account",
					" *2*  Delete an Account",
					" *3*  Switch an Account", "",
					" *4*  Find Loan-Interest",
					" *5*  Find Amount-Balance",
					" *6*  Find Amount-Deposit",
					" *7*  Find Amount-Withdraw", "",
					" *0*  Quit Axis-Bank", "",
					"Enter Choice: $"
				);

		getChoice = Integer.parseInt(stdin.get(0).trim());
	}


	public static void run() {
		AxisRun();
	}


	public static void AxisRun() {

		currentAxisAcc = null;
		while (true) {

			try {

				Design.clearScreen();
				if (errorFlag) {
					Design.showErrorMessage(errorMsg);
					errorFlag = false;
				}
				showMenu();
				Design.loadingProcess(1500);

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

				}Design.continueProcess();

			}catch (NumberFormatException e) {
				Design.loadingProcess(600);
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;

			}catch (IllegalAccessException e) {
				errorMsg = "<Account Expired!>";	errorFlag = true;

			}catch (UnsupportedOperationException e) {
				errorMsg = "<Not Enough Money!>";	errorFlag = true;

			}catch(Exception e) {
				errorMsg = "<HEY!>";	errorFlag = true;
				e.printStackTrace();
				Design.printBox("Pls Report this ErrorType to the Admin.");
				scan.nextLine();

			}

		}
	}
}



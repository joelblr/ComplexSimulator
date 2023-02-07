package banking.barodaBank;

import banking.*;
import design.Design;

import java.util.*;
public class BarodaMain extends BankMain {

	static BarodaBank currentBarodaAcc;
	static HashMap<String, BarodaBank> barodaAccounts;
	
	static {
		currentBarodaAcc = null;
		barodaAccounts = new HashMap<String, BarodaBank>();
	}


	public static void showMenu() {

		List<String> stdin = 
				Design.printBox(
					"Baroda Bank", "",
					" *1*  Create an Account",
					" *2*  Delete an Account",
					" *3*  Switch an Account", "",
					" *4*  Find Loan-Interest",
					" *5*  Find Amount-Balance",
					" *6*  Find Amount-Deposit",
					" *7*  Find Amount-Withdraw", "",
					" *0*  Quit Baroda-Bank", "",
					"Enter Choice: $"
				);

		getChoice = Integer.parseInt(stdin.get(0).trim());
	}


	public static void run() {
		BarodaRun();
	}


	public static void BarodaRun() {

		currentBarodaAcc = null;
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



package banking.barodaBank;

import banking.*;

import java.util.*;
public class BarodaMain extends BankMain {

	public static void run() {
		BarodaRun();
	}


	public static void BarodaRun() {

		currentAcc = null;
		LinkedList<Bank> barodaAcc = accounts.get("axis");
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
						BarodaBank.createAccount(barodaAcc);
						break;
	
					case 2 :
						BarodaBank.deleteAccount(barodaAcc);
						break;

					case 3 :
						BarodaBank.switchAccount(barodaAcc);
						break;

					case 4 :
						BarodaBank.loanInterest(currentAcc);
						break;

					case 5 :
						BarodaBank.amountBalance(currentAcc);
						break;
	
					case 6 :
						BarodaBank.amountDeposit(currentAcc);
						break;

					case 7 :
						BarodaBank.amountWithdraw(currentAcc);
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

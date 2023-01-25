package banking.axisBank;

import banking.*;

import java.util.*;
public class AxisMain extends BankMain {

	public static void run() {
		AxisRun();
	}


	public static void AxisRun() {

		currentAcc = null;
		LinkedList<Bank> axisAcc = accounts.get("axis");
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
						AxisBank.createAccount(axisAcc);
						break;
	
					case 2 :
						AxisBank.deleteAccount(axisAcc);
						break;

					case 3 :
						AxisBank.switchAccount(axisAcc);
						break;

					case 4 :
						AxisBank.loanInterest(currentAcc);
						break;

					case 5 :
						AxisBank.amountBalance(currentAcc);
						break;
	
					case 6 :
						AxisBank.amountDeposit(currentAcc);
						break;

					case 7 :
						AxisBank.amountWithdraw(currentAcc);
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

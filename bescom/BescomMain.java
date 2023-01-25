package bescom;

import java.util.InputMismatchException;

import main.SuperMain;
public class BescomMain extends SuperMain {


	public static Bescom EB = new Bescom();


	public static void setMenu() {
		menuWidth = 26 + 11; title = "BESCOM";
		menu.clear();
//		menu.add("Clear Screen");
		menu.add("Enter Account Credentials");
		menu.add("Enter Monthly-Unit Details");
		menu.add("Update Unit Details");
		menu.add("Print a Bill");
		menu.add("Print All Bills");
		menu.add("Close BESCOM");
	}


	public static void run() {
		BescomRun();
	}


	public static void BescomRun() {

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
						EB.getCredentials();
						break;
	
					case 2 :
						EB.printMonthBill();
						break;

					case 3 :
						EB.updateUnits();
						break;

					case 4 :
						EB.printMonthBill();
						break;

					case 5 :
						EB.printAllBills();
						break;

					case 6 :
						return;

					default :
						errorMsg = "<INVALID CHOICE!>";  errorFlag = true;
						throw new NumberFormatException();

				}continueProcess();

			}catch (ArithmeticException e) {
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;
//				e.printStackTrace();

			}catch (InputMismatchException | NumberFormatException e) {
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;
//				e.printStackTrace();

			}catch(Exception e) {
				errorMsg = "<HEY!>";	errorFlag = true;
//				e.printStackTrace();

			}

		}
	}
}

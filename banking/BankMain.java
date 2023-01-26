package banking;

import main.SuperMain;
import banking.axisBank.*;
import banking.barodaBank.*;

import java.util.*;
public class BankMain extends SuperMain {

//Forget abt these lines..........
//	public static HashMap<String, HashMap> accounts;
//	public static Bank currentAcc;
//	static {
//		currentAcc = null;
//		accounts = new HashMap<String, HashMap>();
//	}


	public static void setMenu() {
		menuWidth = 13 + 11; title = "Banks of India";
		menu.clear();
//		menu.add("Clear Screen");
		menu.add("Close Banking");
		menu.add("Axis Bank");
		menu.add("IDBI Bank");
		menu.add("Canara Bank");
		menu.add("Baroda Bank");
//		menu.add("Close Banking");
	}


	public static void run() {
		BankRun();
	}


	public static void BankRun() {

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
						AxisMain.run();
						break;
	
					case 2 :
//						IDBIMain.run();
						break;

					case 3 :
//						CanaraMain.run();
						break;

					case 4 :
						BarodaMain.run();
						break;

					case 0 :
						return;

					default :
						errorMsg = "<INVALID CHOICE!>";  errorFlag = true;
						throw new NumberFormatException();

				}//continueProcess();

			}catch (InputMismatchException | NumberFormatException e) {
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;

			}catch(Exception e) {
				errorMsg = "<HEY!>";	errorFlag = true;

			}

		}
	}
}


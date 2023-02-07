package banking;

import main.SuperMain;

import java.util.List;

import banking.axisBank.*;
import banking.barodaBank.*;
import design.Design;

//import java.util.*;
public class BankMain extends SuperMain {

	/* HashMap accounts = {
				 "axis" : bankAccount1 -> bankAccount2 -> bankAccount3, -> ...
				 "idbi" : bankAccount1 -> bankAccount2 -> bankAccount3, -> ...
				 "canara" : bankAccount1 -> bankAccount2 -> bankAccount3, -> ...
				 "baroda" : bankAccount1 -> bankAccount2 -> bankAccount3, -> ...
				}
	 */


	public static void showMenu() {
		List<String> stdin = 
				Design.printBox(
						"Banks of India", "",
						" *1*  Axis Bank",
						" *2*  IDBI Bank",
						" *3*  Canara Bank",
						" *4*  Baroda Bank",
						" *0*  Close Banking", "",
						"Enter Choice: $"
					);

		getChoice = Integer.parseInt(stdin.get(0).trim());
	}


	public static void run() {
		BankRun();
	}


	public static void BankRun() {

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

			}catch (NumberFormatException e) {
				Design.loadingProcess(600);
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;

			}catch(Exception e) {
				errorMsg = "<HEY!>";	errorFlag = true;
				e.printStackTrace();
				Design.printBox("Pls Report this ErrorType to the Admin.");
				scan.nextLine();

			}

		}
	}
}


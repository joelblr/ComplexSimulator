package main;

import design.*;
import calci.*;
import bescom.*;
import company.*;
import banking.*;
import java.util.*;


public class SuperMain {

	/* Static Fields */
	public static Scanner scan;
	public static int getChoice;
	public static String errorMsg;
	public static boolean errorFlag;

	static {
		errorFlag = false;
		scan = new Scanner(System.in);
	}



	public static void showMenu() {

		List<String> stdin = 
				Design.printBox(
					"Program Simulator", "",
					" *1*  Casio fx-707",
					" *2*  Celonis",
					" *3*  BESCOM",
					" *4*  Cash Ware",
					" *0*  Close Program Simulator", "",
					"Enter Choice: $"
				);

		getChoice = Integer.parseInt(stdin.get(0).trim());
	}



	public static void run() {
		return;
	}


	public final static void main(String[] args) {

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
						CalciMain.run();
						break;

					case 2 :
						EmployeeMain.run();
						break;

					case 3 :
						BescomMain.run();
						break;

					case 4 :
						BankMain.run();
						break;

					case 0 :
						scan.close();
						Design.clearScreen();
						System.exit(0);

					default :
						errorMsg = "<INVALID CHOICE!>";  errorFlag = true;
				}

			}catch (ArithmeticException e) {
				errorMsg = "<DIVISION BY ZERO!>";	errorFlag = true;
				e.printStackTrace();

			}catch (NumberFormatException e) {
				System.out.println();
				Design.loadingProcess(600);
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;

			}
		}

	}
}


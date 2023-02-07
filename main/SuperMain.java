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



	public final static void showErrorMessage(String msg) {
//		Design.printBox(new String(Character.toChars(0x2757))+" "+msg);
		Design.printBox(msg);
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


	public final static void loadingProcess(int time) {

		String a = "|/-\\";
		long start = System.currentTimeMillis();
		try {
			int i = 0;
			Design.printBox("Loading your Choice   ");
			System.out.print("\033[2A\033["+(8+4+21)+"C");
			while (true) {
				
				System.out.print(a.charAt(i) + " ");
				Thread.sleep(150);
				System.out.print("\b\b");
				long now = System.currentTimeMillis();
				if (now - start >= time) break;
				i = (i+1) % 4;
			}

		}catch(Exception e) {}
		finally {
			System.out.print("\033[1B");
			for (int i = 0; i < 3; i++) {
				System.out.print("\033[2K");
				System.out.print("\033[1A");
			}
		}
		System.out.println();
	}


	public final static void continueProcess() {
		Design.printBox("PRESS <ENTER> KEY TO CONTINUE... $");
	}


	public static void run() {
		return;
	}


	public final static void main(String[] args) {

		while (true) {

			try {

				Design.clearScreen();
				if (errorFlag) {
					showErrorMessage(errorMsg);
					errorFlag = false;
				}
				showMenu();
				loadingProcess(1500);

				switch (getChoice) {

//					case 0 :
//						break;

					case 1 :
//						errorMsg = "WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...";  errorFlag = true;
						CalciMain.run();
						break;

					case 2 :
//						errorMsg = "WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...";  errorFlag = true;
						EmploMain.run();
						break;

					case 3 :
//						errorMsg = "WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...";  errorFlag = true;
						BescomMain.run();
						break;

					case 4 :
//						errorMsg = "WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...";  errorFlag = true;
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
				loadingProcess(500);
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;

			}
		}

	}
}


package calci;

import main.SuperMain;
import java.util.*;
public class CalciMain extends SuperMain {

	public static void setMenu() {
		menuWidth = 27 + 11; title = "Casio fx-991+";
		menu.clear();
//		menu.add("Clear Screen");
		//TODO : case1, case2
		menu.add("Solve Linear Equation"); menu.add("Solve Quadratic Equation");
		menu.add("Solve Boolean Expression"); menu.add("Solve Arithmetic Expression");
		menu.add("Close Casio fx-707");
	}


	public static void run() {
		CalciRun();
	}


	public static void CalciRun() {

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
						errorMsg = "WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...";  errorFlag = true;
						throw new Exception();
						//Equations.LinearEqnRun();
						//break;
	
					case 2 :
						Equations.QuaticEqnRun();
						break;

					case 3 :
						BoolExp.run();
						break;

					case 4 :
						ArithExp.run();
						break;

					case 5 :
						return;

					default :
						errorMsg = "<INVALID CHOICE!>";  errorFlag = true;
						throw new NumberFormatException();
				}
				continueProcess();

			//To catch Errors: Implement Verify.java inside Convertor.java
			}catch (ArithmeticException e) {
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;
				e.printStackTrace();

			}catch (InputMismatchException | NumberFormatException e) {
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;
				e.printStackTrace();

			}catch(Exception e) {
				errorMsg = "<HEY!>";	errorFlag = true;
				e.printStackTrace();

			}

		}

	}
}




//package calci;
//
//
//import java.util.*;
////import java.lang.Thread;
//public class CalciMain {
//
//	public static final void clearScreen() {
//		System.out.print("\033[H\033[2J");
//		System.out.flush();
//		try {
//			final String os = System.getProperty("os.name");
//			if (os.contains("Windows"))
//				Runtime.getRuntime().exec("cls");
//			else
//				Runtime.getRuntime().exec("clear");
//
//		}catch (final Exception e) {
//			System.out.println(e + " YO.....");
//			e.printStackTrace();
//		}
//	}
//
//	public static void run() {
//
//		boolean flag = true;
//		Scanner sc = new Scanner(System.in);
//
//		while (flag) {
//
//			try {
//				clearScreen();
//				System.out.println("*".repeat(50));
//				System.out.println("1. Solve Arithmetic Expression\n2. Solve Boolean Expression\n3. Exit");
//				System.out.println("*".repeat(50));
//				System.out.print("Enter Choice: ");
////				int choice = CalciMain.sc.nextInt();
//				int choice = sc.nextInt();
//
//				switch (choice) {
//
//					case 1 :
//						ArithExp.run();
//						break;
//
//					case 2 :
//						BoolExp.run();
//						break;
//
//					case 3 :
//						System.out.println("<".repeat(50));
//						flag = false;
//						break;
//
//					default :
//						System.out.println("INVALID CHOICE!");
//				}
//				System.out.print("PRESS ENTER KEY TO CONTINUE...  ");
//				sc.nextLine();
//				sc.nextLine();
//
//			}catch (InputMismatchException e) {
//				System.out.println("INVALID INPUT! ");
////				sc.nextLine();
//			}
//		}
//
//	}
//}

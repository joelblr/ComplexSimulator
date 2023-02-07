package company;

import design.Design;
import main.*;
import java.util.*;

public class EmployeeMain extends SuperMain {

	Boss b1 = new Boss();

	public static void showMenu() {

		List<String> stdin = 
				Design.printBox(
					"BESCOM", "",
					" *1*  Hire Employee",
					" *2*  Fire Employee",
					" *3*  Display Salary Slip",
					" *0*  Close Company", "",
					"Enter Choice: $"
				);

		getChoice = Integer.parseInt(stdin.get(0).trim());
	}

	public static void run() {
		new EmployeeMain().EmployeeRun();
	}


	public void EmployeeRun() {

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
						b1.hireEmployee();
						break;
	
					case 2 :
						b1.fireEmployee();
						break;

					case 3 :
						b1.showNetwork();
						break;

					case 0 :
						return;

					default :
						errorMsg = "<INVALID CHOICE!>";  errorFlag = true;
						throw new NumberFormatException();

				}Design.continueProcess();

			}catch (ArithmeticException e) {
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;

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


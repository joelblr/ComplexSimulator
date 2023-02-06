package calci;

import design.Design;
import main.SuperMain;
import java.util.*;


public class CalciMain extends SuperMain {


	public static void showMenu() {
		List<String> stdin = 
				Design.printBox(
					"Casio fx-991+", "",
					" *1*  Solve Linear Equation",
					" *2*  Solve Quadratic Equation",
					" *3*  Solve Boolean Expression",
					" *4*  Solve Arithmetic Expression",
					" *0*  Close Casio fx-707", "",
					"Enter Choice: $"
				);

		getChoice = Integer.parseInt(stdin.get(0).trim());
	}


	public static void run() {
		CalciRun();
	}


	public static void CalciRun() {

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

					case 1 :
						Equations.LinearRun();
						break;
	
					case 2 :
						Equations.QuadraticRun();
						break;

					case 3 :
						Expressions.booleanRun();
						break;

					case 4 :
						Expressions.arithmeticRun();
						break;

					case 0 :
						return;

					default :
						errorMsg = "<INVALID CHOICE!>";  errorFlag = true;
						throw new NumberFormatException();
				}
				continueProcess();

			//To catch Errors: Implement Verify.java inside Convertor.java
			}catch (ArithmeticException e) {
				loadingProcess(600);
				errorMsg = "<DIVISION BY ZERO!>";	errorFlag = true;

			}catch (NumberFormatException e) {
				loadingProcess(600);
				errorMsg = "<INVALID INPUTs!>";	errorFlag = true;

			}catch (InputMismatchException e) {
				loadingProcess(600);
				errorMsg = "<NOT A QUADRATIC!>";	errorFlag = true;

			}catch(ArrayIndexOutOfBoundsException e) {
				errorMsg = "<NOT ENOUGH INPUTS!>";	errorFlag = true;
				e.printStackTrace();
				scan.nextLine();

			}catch(Exception e) {
				errorMsg = "<HEY!>";	errorFlag = true;
				e.printStackTrace();
				scan.nextLine();

			}

		}

	}
}




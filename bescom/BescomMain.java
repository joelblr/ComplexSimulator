package bescom;

import java.util.List;

import design.Design;
import main.SuperMain;
public class BescomMain extends SuperMain {


	public static Bescom EB = new Bescom();


	public static void showMenu() {

		List<String> stdin = 
				Design.printBox(
					"BESCOM", "",
					" *1*  Enter Account Credentials",
					" *2*  Enter Monthly-Unit Details",
					" *3*  Update Unit Details",
					" *4*  Print a Bill",
					" *5*  Print All Bills",
					" *0*  Close BESCOM", "",
					"Enter Choice: $"
				);

		getChoice = Integer.parseInt(stdin.get(0).trim());
	}

	public static void run() {
		BescomRun();
	}


	public static void BescomRun() {

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

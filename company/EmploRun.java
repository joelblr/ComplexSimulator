package company;

import java.util.Scanner;

public class EmploRun extends Network {

	Scanner cn = new Scanner(System.in);

//	public static void main(String[] args) {
//		run();
//	}

	public static void run() {
		new EmploRun().menu();
	}


	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private void menu() {

		boolean flag = true;  int choice = 0;

		while (flag) {

			try {
				clearScreen();
				System.out.println("*".repeat(50));

				//You can append the Menu and append the cases and Network methods accordingly
				System.out.println("1. Hire Employee\n2. Fire Employee\n3. Salary Slip\n4. Exit");
				System.out.println("*".repeat(50));
				System.out.print("Enter Choice: ");
				scn.nextLine();

				switch (choice) {

					case 1 :
						hireEmployee();
						break;

					case 2 :
						fireEmployee();
						break;

					case 3 :
						showNetwork();
						break;

					case 4 :
						System.out.println("<".repeat(50));
						flag = false;
						break;

					default :
						System.out.println("INVALID CHOICE!");
				}
				if (flag) {
				System.out.print("PRESS ENTER KEY TO CONTINUE...  ");
					scn.nextLine();
					scn.nextLine();
				}

			}catch (Exception e) {
				System.out.println("INVALID INPUT! " + e);
			}

		}

	}
}

//	private void menu() {
//
//		int flag = 0;  int choice;
//
//		while (flag++ < 2) {
//
//			try {
//				clearScreen();
//				System.out.println("*".repeat(50));
//				System.out.println("1. Hire Employee\n2. Fire Employee\n3. Salary Slip\n4. Exit");
//				System.out.println("*".repeat(50));
//				System.out.print("Enter Choice: ");
//				choice = nk.scn.nextInt();
//
//				switch (choice) {
//
//					case 1 :
//						nk.hireEmployee();
//						break;
//
//					case 2 :
//						nk.fireEmployee();
//						break;
//
//					case 3 :
//						nk.showNetwork();
//						break;
//
//					case 4 :
//						System.out.println("<".repeat(50));
//						flag++;
//						break;
//
//					default :
//						System.out.println("INVALID CHOICE!");
//				}
//				System.out.println("PRESS ENTER KEY TO CONTINUE...  ");
////				nk.scn.nextLine();
//
//			}catch (Exception e) {
//				System.out.println("INVALID INPUT! " + e);
//			}
//
//		}
//
//	}
//}
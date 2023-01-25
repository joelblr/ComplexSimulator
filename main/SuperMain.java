package main;

import calci.*;
import bescom.*;
import company.*;
import banking.*;
import java.util.*;
public class SuperMain {

	public static Scanner scan;
	public static boolean errorFlag;
	public static List<String> menu;
	public static int menuWidth, getChoice;
	public static String title, choice, errorMsg;


	static {
		errorFlag = false;
		choice = "Enter Choice: ";
		scan = new Scanner(System.in);
		menu = new LinkedList<String>();
	}


	public final static void clearScreen() {

		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

		}catch(Exception e) {
			System.out.print("\033[H\033[2J");
		}
	}


	public final static void showErrorMessage(String msg) {
		System.out.println("    ┌"+"─".repeat(msg.length()+6)+"┐");
		System.out.println("    │ "+new String(Character.toChars(0x2757))+" "+msg+"  │");
		System.out.println("    └"+"─".repeat(msg.length()+6)+"┘");
		System.out.print("\033[1A\033[1D");
	}


	public static void setMenu() {
		menuWidth = 3 + 5 + 23 + 3; title = "Program Simulator";
		menu.clear();
//		menu.add("Clear Screen");
		menu.add("Casio fx-707"); menu.add("Celonis");
		menu.add("BESCOM"); menu.add("Cash Ware");
		menu.add("Close Program Simulator");
	}


	public final static void showMenu() {

		int k = 1;
		System.out.println("    ┌"+"─".repeat(menuWidth)+"┐");
		System.out.println("    │  "+ title + " ".repeat(menuWidth - title.length()-2) + "│");
		System.out.println("    ├"+"─".repeat(menuWidth)+"┤");
		for(String item : menu)
			System.out.println("    │   <"+(k++)+">  " + item+ " ".repeat(menuWidth - item.length()-8) + "│");

		System.out.println("    ├"+"─".repeat(menuWidth)+"┤");
		System.out.println("    │  "+ choice + " ".repeat(menuWidth - choice.length()-2) + "│");
		System.out.print("    └"+"─".repeat(menuWidth)+"┘");
		System.out.print("\033[1A \033["+(menuWidth - choice.length())+"D");

		getChoice = Integer.parseInt(scan.nextLine());
		System.out.println();
		
	}


	public final static void loadingProcess() {

		String a = "|/-\\";
		long start = System.currentTimeMillis();
		try {
			int i = 0;
			System.out.println("    ┌"+"─".repeat(menuWidth)+"┐");
			int space = menuWidth-21;
			System.out.println("    │  Loading your Choice" + " ".repeat(space) + "│");
			System.out.print("    └"+"─".repeat(menuWidth)+"┘");
			System.out.print("\033[1A\033["+((int)Math.ceil(space*0.75))+"D");
			while (true) {
				
				System.out.print(a.charAt(i) + " ");
				Thread.sleep(150);
				System.out.print("\b\b");
				long now = System.currentTimeMillis();
				if (now - start >= 1500) break;
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
		System.out.println("    ┌"+"─".repeat(37)+"┐");
		System.out.println("    │  PRESS <ENTER> KEY TO CONTINUE...   │");
		System.out.print(  "    └"+"─".repeat(37)+"┘");
		System.out.print("\033[1A\033["+(3)+"D");
		scan.nextLine();	//scan.nextLine();
		System.out.println();
	}


	public static void run() {
		return;
	}


	public final static void main(String[] args) {

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

					case 0 :
						break;

					case 1 :
//						errorMsg = "WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...";  errorFlag = true;
						CalciMain.run();
						break;

					case 2 :
						errorMsg = "WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...";  errorFlag = true;
//						EmploMain.run();
						break;

					case 3 :
//						errorMsg = "WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...";  errorFlag = true;
						BescomMain.run();
						break;

					case 4 :
						errorMsg = "WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...";  errorFlag = true;
//						BankMain.run();
						break;

					case 5 :
						scan.close();
						clearScreen();
						System.exit(0);

					default :
						errorMsg = "<INVALID CHOICE!>";  errorFlag = true;
				}

			}catch (InputMismatchException | NumberFormatException e) {
				errorMsg = "<INVALID INPUT!>";	errorFlag = true;

			}
		}

	}
}





/**

	Design

─ ━ │ ┃ ┄ ┅ ┆ ┇ ┈ ┉ ┊ ┋
╌ ╍ ╎ ╏ ═ ║

 ┌ ┍ ┎ ┏ ┐ ┑ ┒ ┓
 └ ┕ ┖ ┗ ┘ ┙ ┚ ┛
 ├ ┝ ┞ ┟ ┠ ┡ ┢ ┣ ┤ ┥ ┦ ┧ ┨ ┩ ┪ ┫
 ┼ ┽ ┾ ┿ ╀ ╁ ╂ ╃ ╄ ╅ ╆ ╇ ╈ ╉ ╊ ╋
 ┬ ┭ ┮ ┯ ┰ ┱ ┲ ┳
 ┴ ┵ ┶ ┷ ┸ ┹ ┺ ┻

  ╒ ╓ ╔ ╕ ╖ ╗
  ╘ ╙ ╚ ╛ ╜ ╝
  ╞ ╟ ╠ ╡ ╢ ╣
  ╤ ╥ ╦ ╧ ╨ ╩ ╪ ╫ ╬ 
 **/


/**
 * 
 * │──
("║ . │ . ║ . ║")
("╟───┼───╫───╢")
*/


/***
import java.util.*;


import calci.*;
import company.*;

//TODO: make sure to clear buffer after every sc.next...() for safety
public class SuperMain {

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
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
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			try {

				clearScreen();
				System.out.println("-".repeat(50));
				System.out.println("0. Clear Screen\n1. Calci\n2. Employee\n3. Bescom\n4. Banking\n5. Exit");
				System.out.println("-".repeat(50));
				System.out.print("Enter Choice: ");
				int choice = sc.nextInt();				
				System.out.println(">".repeat(50));

				switch (choice) {

					case 0 :
						clearScreen();
						break;

					case 1 :
						CalciMain.run();
						break;

					case 2 :
						System.out.println("WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...");
						EmploRun.run();
						break;

					case 3 :
						System.out.println("WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...");
//						Bescom.run();
						break;

					case 4 :
						System.out.println("WORK-IN-PROGRESS, PLZ WAIT FOR A FEW WEEKS...");
//						Bank.run();
						break;

					case 5 :
						sc.close();
						System.out.println("-".repeat(50));
						System.exit(0);

					default :
						System.out.println("INVALID CHOICE!");
				}

			}catch (InputMismatchException e) {
				System.out.println("INVALID INPUT! ");
//				sc.nextLine();
			}
		}
	}

}

 */

/**
class SpinningRod {

	public static void wait(String[] args) throws InterruptedException {

		String a = "|/-\\";
        //System.out.print("\033[2J");   // hide the cursor
        long start = System.currentTimeMillis();
        while (true) {
            for (int i = 0; i < 4; i++) {
                //System.out.print("\033[2J");     // clear terminal
                //System.out.print("\033[0;0H");   // place cursor at top left corner
                for (int j = 0; j < 80; j++) {   // 80 character terminal width, say
                    System.out.print(a.charAt(i));
                }
                Thread.sleep(250);
            }
            long now = System.currentTimeMillis();
            // stop after 20 seconds, say
            if (now - start >= 3000) break;
        }
        System.out.print("\033[?25h"); // restore the cursor
    }
}
*/
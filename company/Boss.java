package company;

import java.util.Scanner;

public class Boss {

	static Scanner Bsc = new Scanner(System.in);
	
	//Standard Coeff for any Employee, define they as static and **retrieve them thru func call
	private static double da = 0.45, hra = 0.25, cca = 0.10;
	private static double pf = 0.30, pt = 0.15, it = 0.7;

	//**retrieving them thru func call
	static double getConst() {
		return da + hra + cca - (pf + pt + it);
	}

	/**
	 * Write 3 or more static-double methods for A, B, C... grade Employees
	 and based on the type of employee return the constants individually or as a whole..
	 
	 Ex:
	 static double gradeA() {
	 	return (getConst() + bonusCoeff1 + ...)
	 }
	 static double gradeB() {
	 	return (getConst() + bonusCoeff2 + ...)
	 }
	 */
}

package calci;

import java.util.*;
public class Equations {

	static Scanner sc;
	static double a, b, c, d;
	static double r1, r2;

	static {
		sc = new Scanner(System.in);
		a = b = c = d = 0.0;
		r1 = r2 = 0.0;
	}

	protected static void LinearEqnRun() {
		LinearEqn();
	}

	private static void LinearEqn() {
		//TODO
	}


	protected static void QuaticEqnRun() {
		QuaticEqn();
	}

	private static void QuaticEqn() {
		//TODO
		System.out.println("    ┌"+"─".repeat(44)+"┐");
		System.out.println("    │  CONSIDER THE EQUATION : Ax² + Bx + C = 0  │");
		System.out.println("    │  ENTER VALUES OF A, B, C :" + " ".repeat(17) + "│");
		System.out.print("    └"+"─".repeat(44)+"┘");
		System.out.print("\033[1A\033[17D");

		a = Double.parseDouble(sc.next());
		b = Double.parseDouble(sc.next());
		c = Double.parseDouble(sc.next());

		d = b*b - 4*a*c;

		System.out.println("    ├"+"─".repeat(44)+"┤");
		if (d >= 0) {

			if (d == 0)
				System.out.format("    │  REAL AND EQUAL ROOTS %s\n", " ".repeat(21)+"│");
			else
				System.out.format("    │  REAL AND DISTINCT ROOTS %s\n", " ".repeat(18)+"│");

			r1 = (-b + Math.sqrt(d))/(2*a);
			r2 = (-b - Math.sqrt(d))/(2*a);

			//alternative
//			System.out.println("ROOT1: " + r1);
//			System.out.println("ROOT2: " + r2);

			//alternative
//			System.out.format("ROOT1: %.4f\n", r1);
//			System.out.format("ROOT2: %.4f\n", r2);

			r1 = Math.round(r1*1000.0)/1000.0;  r2 = Math.round(r2*1000.0)/1000.0;

			System.out.println("    ├"+"─".repeat(44)+"┤");
			System.out.format ("    │  ROOT1: %.4f %s\n", r1, " ".repeat(27)+"│");
			System.out.format ("    │  ROOT2: %.4f %s\n", r2, " ".repeat(27)+"│");
			System.out.println("    └"+"─".repeat(44)+"┘");

		}else { 
			System.out.format("    │  IMAGINARY ROOTS! %s\n", " ".repeat(25)+"│");

			r1 = -b/(2*a);
			r2 = Math.sqrt(-d)/(2*a);

			//alternative
//			System.out.println("ROOT1: " + r1 + " + i" + r2);
//			System.out.println("ROOT2: " + r1 + " - i" + r2);

			//alternative
			//r1 = Math.round(r1*1000.0)/1000.0;  r2 = Math.round(r2*1000.0)/1000.0;

			System.out.println("    ├"+"─".repeat(44)+"┤");
			if (r1 >= 0) {
				System.out.format ("    │  ROOT1: %.4f + i%.4f %s\n", r1, r2, " ".repeat(18)+"│");
				System.out.format ("    │  ROOT2: %.4f - i%.4f %s\n", r1, r2, " ".repeat(18)+"│");
				
			}else {
				System.out.format ("    │  ROOT1: %.4f + i%.4f %s\n", r1, r2, " ".repeat(17)+"│");
				System.out.format ("    │  ROOT2: %.4f - i%.4f %s\n", r1, r2, " ".repeat(17)+"│");
			}
			System.out.println("    └"+"─".repeat(44)+"┘");

		}
	}
}

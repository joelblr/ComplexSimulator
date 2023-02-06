package calci;

import design.Design;
import java.util.*;


public class Equations {


	protected static void LinearRun() {
		LinearEqn();

	}private static void LinearEqn() {
		Matrix m = new Matrix();
		m.solveSLE();
	}


	protected static void QuadraticRun() {
		QuaticEqn();

	}private static void QuaticEqn() {

		double a, b, c, d, r1, r2;

		List<String> stdin = 
				Design.printBox(
						"CONSIDER THE EQUATION : Ax² + Bx + C = 0", "",
						"ENTER VALUES OF A, B, C : $"
					);

		String[] coeff = stdin.get(0).split(" ");

		if (coeff.length > 3)
			throw new NumberFormatException();

		a = Double.parseDouble(coeff[0]);

		if (a == 0.0)
			throw new InputMismatchException();

		b = Double.parseDouble(coeff[1]);
		c = Double.parseDouble(coeff[2]);

		d = b*b - 4*a*c;

		String[] ans = new String[4];

		ans[1] = "";
		if (d >= 0) {

			if (d == 0)
				ans[0] = "REAL AND EQUAL ROOTS";
			else
				ans[0] = "REAL AND DISTINCT ROOTS";

			r1 = (-b + Math.sqrt(d))/(2*a);
			r2 = (-b - Math.sqrt(d))/(2*a);

			ans[2] = String.format("ROOT1: %.4f", r1);
			ans[3] = String.format("ROOT2: %.4f", r2);

		}else { 
			ans[0] = "IMAGINARY ROOTS!";

			r1 = -b/(2*a);
			r2 = Math.sqrt(-d)/(2*a);

			ans[2] = String.format ("ROOT1: %.4f + %.4fi", r1, r2);
			ans[3] = String.format ("ROOT2: %.4f - %.4fi", r1, r2);

		}
		Design.printBox(ans);
	}


}



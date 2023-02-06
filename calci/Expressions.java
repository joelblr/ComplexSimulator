package calci;

import design.Design;
import java.util.*;

public class Expressions extends Convertor {


	private static void getExpression(String type) {

		List<String> stdin = 
				Design.printBox(
						"ENTER " + type + " EXPRESSION: $",
						" ".repeat(55)
					);

		String infix = "(" + stdin.get(0) + ")";
		
		if (type == "ARITHMETIC") {
			findPostfix(infix, 'A');

		}else {
			findPostfix(infix, 'B');
			N = getUnique().size();
			BoolInput = new int[N];
		}
	}


	//Arithmetic Expression
	public static void arithmeticRun() {
		getExpression("ARITHMETIC");
		getAnswer();
	}

	private static void getAnswer() {

		String ans = Double.toString(Math.round(evalPostfix(new int[0])*1000.0)/1000.0);
		Design.printBox(String.format("ANSWER:  %s", ans));

	}


	//Boolean Expression
	private static int N;
	private static int BoolInput[];

	public static void booleanRun() {
		getExpression("BOOLEAN");
		printTruthTable();

	}private static void nextInput() {
		for (int idx = N-1; idx > -1; idx--) {
			BoolInput[idx] ^= 1;
			if (BoolInput[idx] == 1)
				return;
		}

	}private static void printTruthTable() {

		String row = "";
		Design.printHead(4*N+3);

		for (char key : getUnique().keySet()) {
			row += " "+key+" │";

		}row += " f ";

		Design.printJoinRow(row);
		row = "───┼".repeat(N) + "───";
		Design.printJoinRow(row);

		for (int k = 0; k < 1<<N; k++) {
			row = "";
			for (int val : BoolInput) {
				row += " "+val+" │";

			}row += " " + (int)evalPostfix(BoolInput) + " ";

			Design.printJoinRow(row);
			nextInput();

		}Design.printBase(4*N + 3);

		return;
	}


}

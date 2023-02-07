package calci;

public class BoolExp extends Convertor {


	private static int N;
	private static int BoolInput[];


	public static void run() {
		getExpression();
		printTruthTable();
	}


	private static void getExpression() {
		System.out.println("    ┌"+"─".repeat(30+20)+"┐");
		System.out.println("    │  ENTER A BOOLEAN EXPRESSION: "+" ".repeat(20)+"│");
		System.out.print(  "    └"+"─".repeat(30+20)+"┘");
		System.out.print("\033[1A\033[21D");

//		String infix = CalciMain.sc.nextLine();
		String infix = sc.nextLine();
		findPostfix("("+infix+")", 'B');
		N = getUnique().size();
		BoolInput = new int[N];
	}


	private static void nextInput() {
		for (int idx = N-1; idx > -1; idx--) {
			BoolInput[idx] ^= 1;
			if (BoolInput[idx] == 1)
				return;
		}
	}


	private static void printTruthTable() {
		for (char key : getUnique().keySet())
			System.out.print(" "+key+" │");
		System.out.println(" Y");
		System.out.println("───┼".repeat(N) + "─── ");

		for (int k = 0; k < 1<<N; k++) {
			for (int val : BoolInput)
				System.out.print(" "+val+" │");
			System.out.println(" " + (int)evalPostfix(BoolInput));
			nextInput();
		}
		return;
	}


}

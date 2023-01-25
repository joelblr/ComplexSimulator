package calci;


public class ArithExp extends Convertor{


	public static void run() {
		getExpression();
		getAnswer();
	}


	private static void getExpression() {
		System.out.print("ENTER A ARITHMETIC EXPRESSION: ");
//		String infix = CalciMain.sc.nextLine();
		String infix = sc.nextLine();
		findPostfix("("+infix+")", 'A');
	}


	private static void getAnswer() {
		System.out.println("ANSWER: ₹" + evalPostfix(new int[0]));
	}

}

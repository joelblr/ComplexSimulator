package calci;
import java.util.*;


public class Convertor {


	static char type;
//	static String postfix[];
	static ArrayList <String> postfix;

	public static LinkedHashMap <Character, Integer> unique;
	public static Scanner sc;

	private static HashSet<String> operators = new HashSet<>();
	static {
		sc = new Scanner(System.in);
		operators.add("+");operators.add("-");operators.add("*");operators.add("/");
		operators.add("^");
		operators.add("|");operators.add(".");operators.add("!");
	}



	private static int priority(char ch ) {

		if (ch == '(' || ch == '#')
			return 1;
		else if (ch == '+' || ch == '-')
			return 2;
		else if (ch == '*' || ch == '/')
			return 3;
		else if (ch == '^')
			return 4;
		else if (ch == '.')
			return 5;
		else if (ch == '!')
			return 6;
		return 0;
	}


	public static void findPostfix(String infix, char T) {

		type = T;
		int k = 0;
		if (type == 'B')
			 unique = new LinkedHashMap<>();

//		int ptop = -1;
//		postfix = new String[infix.length()];
		postfix = new ArrayList<>();

		Stack <Character> stac = new Stack <>();

//		stac.push('#');
		for (int i = 0; i < infix.length(); i++) {

			char ch1 = infix.charAt(i);
			char ch2 = Character.toUpperCase(ch1);

			if (Character.isWhitespace(ch1)) {
				continue;

			}else if (Character.isLetterOrDigit(ch1)) {
				postfix.add( Character.toString(ch1));
//				postfix[++ptop] = Character.toString(ch1);

				if (type == 'B') {
					if (!unique.containsKey(ch2))
						unique.put(ch2, k++);

				}else {
					ch1 = infix.charAt(i+1);
					while (Character.isDigit(ch1)) {
						int idx = postfix.size()-1;
						postfix.set(idx, postfix.get(idx) + ch1);
//						postfix[ptop] += ch1;
						ch1 = infix.charAt(++i+1);
					}
				}

			}else if (ch1 == '(' || ch1 == '!') {
				stac.push(ch1);

			}else if (ch1 == ')') {

				while (stac.peek() != '(')
					postfix.add( Character.toString(stac.pop()));
//					postfix[++ptop] = Character.toString(stac.pop());
				stac.pop();


			}else {
				while (priority(stac.peek()) >= priority(ch1))
					postfix.add( Character.toString(stac.pop()));
//					postfix[++ptop] = Character.toString(stac.pop());
				stac.push(ch1);

			}
		}
	}



	private static double compute(double x, String op, double y) {

		double ans = 0;

		if (op.equals("!") || op.equals("-")) {
			if (type == 'B')
				ans = (int)x^1;
			else
				ans = x-y;

		}else if (op.equals("|") || op.equals("+")) {
			if (type == 'B')
				ans = (int)x | (int)y;
			else
				ans = x+y;

		}else if (op.equals(".") || op.equals("*")) {
			if (type == 'B')
				ans = (int)x & (int)y;
			else
				ans = x*y;

		}else if (op.equals("^") || op.equals("$")) {
			if (type == 'B')
				ans = (int)x ^ (int)y;
			else
				ans = Math.pow(x, y);

		}else if (op.equals("/"))
			ans = (y != 0.0) ? x/y : y;

		//System.out.println(x + " " + op + " " + y);
		return ans;
	}


	public static double evalPostfix(int[] BoolInput) {

		Stack <Double> stac = new Stack <>();

		for (String ch : postfix) {

			//For Operators
			if (operators.contains(ch)) {
				double y = stac.pop();
				if (ch.equals("!")) {
					stac.push( compute(y, ch, -1));

				}else {
					double x = stac.pop();
					stac.push( compute(x, ch, y));
				}

			//For Boolean Operands
			}else if ( Character.isLetter(ch.charAt(0)) ) {
				char ch1 = ch.charAt(0);

				if ( Character.isLowerCase(ch1) ) {
					ch1 = Character.toUpperCase(ch1);
					stac.push( (double)(BoolInput[ unique.getOrDefault(ch1, -1)] ^ 1) );

				}else
					stac.push( (double)BoolInput[ unique.getOrDefault(ch1, -1)]);

			//For Arithmetic Operands
			}else
				stac.push( Double.valueOf(ch));

		}

		return stac.pop();

	}


}

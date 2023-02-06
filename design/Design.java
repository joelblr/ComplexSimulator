package design;

import java.io.IOException;
import java.util.*;

/**
 * @author Joel A
 * */
public class Design {


	final static Scanner sc;

	final static int factor;
	final static String prefix, mid;
	final static String leftR, rightR;
	final static String leftI, rightI;
	final static String leftT, rightT;
	final static String leftL, rightL;

	static {
		sc = new Scanner(System.in);
		prefix = " ".repeat(8);
		factor = 3 + 0 + 0 + 3;

		mid = "─";
		leftR = prefix + "┌";	rightR = "┐";
		leftT = prefix + "├";	rightT = "┤";
		leftI = prefix + "│   ";	rightI = "   │";
		leftL = prefix + "└";	rightL = "┘";
	}



	/**
	 * Clears the Console of the Terminal
	 */
	public final static void clearScreen() {

		try {//Windows
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

		}catch(IOException | InterruptedException e) {//Linux
			System.out.print("\033[H\033[2J");
		}
	}


	private static int findMaxWidth(String ... str) {
		int max_size = -1;
		for (String s : str)
			if (s.length() > max_size)
				max_size = s.length();
		return max_size;
	}

	/**
	 * Prints the Top-Part of the Message Box
	 * @param   width  -> width of the Message Box
	 */
	public static void printHead(int width) {
		System.out.println(leftR+mid.repeat(width + factor)+rightR);

	}/**
	 * Prints the Message-Part of the Message Box
	 * @param   width    -> width of the Message Box
	 * @param   message  -> message of the Message Box
	 */
	public static void printFrame(int width, String ... message) {

		if (width == 0)
			width = findMaxWidth(message);

		for (String msg : message)
			System.out.println(leftI+msg+" ".repeat(width-msg.length())+rightI);

	}/**
	 * Prints the Bottom-Part of the Message Box
	 * @param   width    -> width of the Message Box
	 */
	public static void printBase(int width) {
		System.out.println(leftL+mid.repeat(width+factor)+rightL);

	}/**
	 * Prints the Joint-Part b/w 2 segments of the Message Box
	 * @param   width    -> width of the Message Box
	 */
	public static void printJoint(int width) {
		System.out.println(leftT+mid.repeat(width+factor)+rightT);

	}


	private static List<String> getStdin(List<Integer[]> inputs, int lines) {

		int i = lines;
		List<String> stdin = new LinkedList<String>();
		System.out.print("\033["+(i-inputs.get(0)[0])+"A");

		i = inputs.get(0)[0] -1;
		for (Integer[] arr : inputs) {

			if ((arr[0]-i) != 0)
				System.out.print("\033["+(arr[0]-i)+"B");
			System.out.print("\033["+arr[1]+"C");
			stdin.add(sc.nextLine());

			i = arr[0]+1;
		}

		System.out.print("\n".repeat(lines - i -1));

		return stdin;
	}

	public static List<String> printBox(String ... msg) {

		List<Integer[]> cursorEof = new LinkedList<Integer[]>();
		int i,  width = findMaxWidth(msg);
		printHead(width);
		int lines = 0;
		for (i = 0; i < msg.length; i++) {
			if (msg[i] == "") {
				printJoint(width);

			}else if (msg[i].endsWith("$")) {
				String field = msg[i].substring(0, msg[i].length()-1);
				printFrame(width, field);

				int len = prefix.length() + factor/2+1 + field.length() + 1;
				cursorEof.add(new Integer[] {i, len});

			}else {
				printFrame(width, msg[i]);

			}lines++;

		}printBase(width); lines += 2;

		List<String> stdin = new LinkedList<String>();
		if (! cursorEof.isEmpty())
			stdin = getStdin(cursorEof, lines);

		return stdin;
	}

	public static void printJoinRow(String row) {
		printFrame(0, row);
	}


}



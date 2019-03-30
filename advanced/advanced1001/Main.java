package advanced1001;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	/*
	 * Calculate a+b and output the sum in standard format -- that is, the digits must be separated into groups of three by commas (unless there are less than four digits).
	 *
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int first = Integer.valueOf(scanner.next());
		int second = Integer.valueOf(scanner.next());
		int plus = first + second;
		scanner.close();
		String out = String.valueOf(plus);
		Stack<String> stack = new Stack<String>();

		for (int i = out.length() - 1; i > -1; i--) {
			if ((out.length() - 1 - i) % 3 == 0 && out.length() - 1 - i != 0) {
				if (i == 0 && out.charAt(i) == '-') {
					stack.push(out.charAt(i) + "");
				} else {
					stack.push(out.charAt(i) + ",");
				}
			} else {
				stack.push(out.charAt(i) + "");
			}
		}
		for (int i = 0; i < out.length(); i++) {
			System.out.print(stack.pop());
		}
	}
}

package basiclevel1002;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String number = in.nextLine();
		in.close();
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += number.charAt(i) - '0';
		}
		Stack<String> stack = new Stack<String>();// 后进先出 push方法插入stack的顶端
													// add方法是插入在vector的底端
		do {
			int unit = sum % 10;
			switch (unit) {
			case 0:
				stack.push("zero");
				break;
			case 1:
				stack.push("one");
				break;
			case 2:
				stack.push("two");
				break;
			case 3:
				stack.push("three");
				break;
			case 4:
				stack.push("four");
				break;
			case 5:
				stack.push("five");
				break;
			case 6:
				stack.push("six");
				break;
			case 7:
				stack.push("seven");
				break;
			case 8:
				stack.push("eight");
				break;
			case 9:
				stack.push("night");
				break;
			}
			sum = sum / 10;
		} while (sum != 0);
		System.out.print(stack.pop());
		while (!stack.isEmpty()) {
			System.out.print(" " + stack.pop());
		}
	}

}
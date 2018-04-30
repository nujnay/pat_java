package basiclevel1001;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = 0;
		int number = in.nextInt();
		while (number != 1) {
			count++;
			if (number % 2 == 0) {
				number = number / 2;
			} else {
				number = (number * 3 + 1) / 2;
			}

		}
		in.close();
		System.out.println(count+"");
	}

}

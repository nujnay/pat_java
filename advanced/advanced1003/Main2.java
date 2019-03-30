package advanced1003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cityNumber = scanner.nextInt();
        int roadNumber = scanner.nextInt();
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int[] rescueTeams = new int[cityNumber];
        for (int i = 0; i < cityNumber; i++) {
            rescueTeams[i] = scanner.nextInt();
        }
        int roadWeight[][] = new int[cityNumber][cityNumber];
        for (int i = 0; i < roadNumber; i++) {
            roadWeight[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();
        }
        int determingLengthCity[] = new int[cityNumber];
        int determingLength[] = new int[cityNumber];
        determingLengthCity[0] = 0;
        determingLength[0] = 0;
        for (int i = 1; i < cityNumber; i++) {

        }

    }
}

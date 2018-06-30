package advanced1003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	/*
	 * 紧急情况 作为城市的救援队的队长 你被给 与一张这个城市特殊的地图
	 * 
	 * 输入第一行包括四个正整数
	 * 
	 * 城市数量n 道路数量m 需要保存到的城市 respectively
	 *  两个城市相连道路的长度
	 * 
	 * output c1 到c2 之间最短的路径长度 最大的救护车数量
	 */

	public static ArrayList<Line> lines;
	public static int c1;
	public static int c2;
	public static ArrayList<Integer> numberOfRescueTeam;

	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		int cityNumber = scanner.nextInt();
		int roadNumber = scanner.nextInt();
		c1 = scanner.nextInt();
		c2 = scanner.nextInt();
		numberOfRescueTeam = new ArrayList<Integer>();
		for (int i = 0; i < cityNumber; i++) {
			int cityteam = scanner.nextInt();
			// System.out.println(cityteam);
			numberOfRescueTeam.add(cityteam);
		}
		lines = new ArrayList<Main.Line>();
		for (int i = 0; i < roadNumber; i++) {
			Line lineOne = main.new Line();
			lineOne.start = Integer.valueOf(scanner.nextInt());
			lineOne.end = Integer.valueOf(scanner.nextInt());
			lineOne.lenth = Integer.valueOf(scanner.nextInt());
			lines.add(lineOne);
		}
		ArrayList<Integer> lengths = new ArrayList<Integer>();
		ArrayList<Integer> used = new ArrayList<Integer>();
		ArrayList<Integer> teamNumberAll = new ArrayList<Integer>();
		iteratorOne(lengths, c1, used, 0, numberOfRescueTeam.get(c1),
				teamNumberAll);
		// System.out.println("");
		 System.out.println(lines.size());
		// System.out.println(lengths.size());
		// System.out.println("+++");
		for (int i = 0; i < lengths.size(); i++) {
			// System.out.println(lengths.get(i));
		}
		// System.out.println("+++");
		for (int i = 0; i < lengths.size(); i++) {
			// System.out.println(teamNumberAll.get(i));
		}
		System.out.println(Collections.min(lengths) + " "
				+ Collections.max(teamNumberAll));

	}

	public static void iteratorOne(ArrayList<Integer> lengths, int start,
			ArrayList<Integer> used, int usedLength, int teamNow,
			ArrayList<Integer> teamNumberAll) {
		for (int i = 0; i < lines.size(); i++) {
			Line lineOne = lines.get(i);
			if (start == lineOne.start) {
				if (lineOne.end == c2) {
					lengths.add(usedLength + lineOne.lenth);
					teamNumberAll.add(teamNow
							+ numberOfRescueTeam.get(lineOne.end));
				} else {
					if (!used.contains(lineOne.end)) {
						used.add(lineOne.end);
						iteratorOne(lengths, lineOne.end, used, usedLength
								+ lineOne.lenth,
								teamNow + numberOfRescueTeam.get(lineOne.end),
								teamNumberAll);
					}
				}
			}
		}
	}

	class Line {
		int start;
		int end;
		int lenth;
	}
}

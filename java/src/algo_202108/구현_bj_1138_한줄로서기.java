package algo_202108;

import java.util.ArrayList;
import java.util.Scanner;

public class 구현_bj_1138_한줄로서기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		int[] line = new int[N];
		for (int i = 0; i < N; i++) {
			line[i] = sc.nextInt();
		}

		for (int i = N - 1; i >= 0; i--) {
			list.add(line[i], i + 1);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}

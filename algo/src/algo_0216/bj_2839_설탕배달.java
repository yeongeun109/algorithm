package algo_0216;

import java.util.Scanner;

public class bj_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = 2000;

		for (int i = 0; 5 * i <= N; i++) {
			int weight = N - 5 * i;

			if (weight % 3 == 0) {
				int three = weight / 3;
				min = Math.min(min, i + three);
			} else
				continue;
		}
		if (min == 2000)
			min = -1;
		System.out.println(min);
	}

}

package algo_0222;

import java.util.ArrayList;
import java.util.Scanner;

public class bj_2635_수이어가기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int result = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> maxList = new ArrayList<Integer>();

		for (int i = n / 2 + 1; i <= n; i++) {
			list.clear();
			list.add(n);
			list.add(i);

			int a = n - i;
			list.add(a);
			cnt = 3;

			int b = i - a;
			if (b >= 0) {
				cnt++;
				list.add(b);
				while (a - b >= 0) {
					int diff = a - b;
					a = b;
					b = diff;
					cnt++;
					list.add(b);
				}
			}

			if (cnt > result) {
				maxList.clear();
				for (int j = 0; j < list.size(); j++)
					maxList.add(list.get(j));
				result = cnt;
			}
		}

		System.out.println(result);
		for (int i = 0; i < maxList.size(); i++) {
			System.out.print(maxList.get(i) + " ");
		}
	}

}

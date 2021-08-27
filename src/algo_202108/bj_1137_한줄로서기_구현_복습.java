package algo_202108;

import java.util.ArrayList;
import java.util.Scanner;

public class bj_1137_한줄로서기_구현_복습 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = N - 1; i >= 0; i--) {
			list.add(arr[i], i + 1);
		}

		for(int i = 0; i < N; i++)
			System.out.print(list.get(i) + " ");
	}
}

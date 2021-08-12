package algo_0812;

import java.util.Scanner;

public class bj_15649_N과M1 {

	static int N, M;
	static boolean[] selected;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new boolean[N];
		numbers = new int[M];
		comb(0, 0);
	}

	static public void comb(int start, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				numbers[cnt] = i + 1;
				comb(i + 1, cnt + 1);
				selected[i] = false;
			}
		}
	}
}

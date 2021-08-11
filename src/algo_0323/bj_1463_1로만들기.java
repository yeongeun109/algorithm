package algo_0323;

import java.util.Scanner;

public class bj_1463_1로만들기 {

	static int[] eval;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		eval = new int[n + 1];
		
		for(int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			
			if(i % 3 == 0 && 1 + eval[i/3] < min)
				min = 1 + eval[i/3];
			if(i % 2 == 0 && 1 + eval[i/2] < min)
				min = 1 + eval[i/2];
			if(1 + eval[i - 1] < min)
				min = 1 + eval[i - 1];

			eval[i] = min;
		}
		
		System.out.println(eval[n]);
	}
}

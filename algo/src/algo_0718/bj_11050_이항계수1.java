package algo_0718;

import java.util.Scanner;

public class bj_11050_이항계수1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int mo = factorial(N - K) * factorial(K);
		int ja = factorial(N);
		System.out.println(ja / mo);
	}

	private static int factorial(int j) {
		int num = 1;
		for(int i = 2; i <= j; i++) {
			 num *= i;
		}
		return num;
	}
	
}

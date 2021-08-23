package algo_0419;

import java.util.Scanner;

public class bj_13707_합분해2 {

	static int N, K, arr[], selected[], res;
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int[][] arr = new int[N + 1][K + 1];
		
		for(int i = 0; i <= N; i++) {
			arr[i][0] = 1;
		}
		for(int i = 1; i <= K; i++) {
			arr[0][i] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j < K; j++) {
				arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000000;
			}
		}
		
		System.out.println(arr[N][K - 1]);
	}
}

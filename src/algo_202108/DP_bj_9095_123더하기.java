package algo_202108;

import java.util.Scanner;

public class DP_bj_9095_123더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			if(dp[n] != 0) {
				System.out.println(dp[n]);
			}else {
				for(int j = 4; j <= n; j++) {
					dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
				}
				System.out.println(dp[n]);
			}
		}
	}

}

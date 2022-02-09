package algo_202108;

import java.util.Scanner;

public class DP_bj_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;

		if (N > 3) {
			for (int i = 4; i <= N; i++) {
				if (i - 5 < 0) {
					if (dp[i - 3] != -1)
						dp[i] = dp[i - 3] + 1;
					else
						dp[i] = -1;
				} else {
					int three, five;
					three = dp[i - 3] != -1 ? dp[i - 3] + 1 : -1;
					five = dp[i - 5] != -1 ? dp[i - 5] + 1 : -1;
					
					if(three == -1 && five != -1)
						dp[i] = five;
					else if(three != -1 && five == -1)
						dp[i] = three;
					else if(three == -1 && five == -1)
						dp[i] = -1;
					else
						dp[i] = Math.min(three, five);
				}
			}
		}

		System.out.println(dp[N]);
	}

}

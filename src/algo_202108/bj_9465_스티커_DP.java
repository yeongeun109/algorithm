package algo_202108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9465_스티커_DP {

	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(in.readLine());
			dp = new int[2][n];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(n > 1) {
				dp[0][1] += dp[1][0];
				dp[1][1] += dp[0][0];
				
				for(int i = 2; i < n; i++) {
					for(int j = 0; j < 2; j++) {
						if(j == 0)
							dp[j][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
						else
							dp[j][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
					}
				}
			}
			
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}
	}

}

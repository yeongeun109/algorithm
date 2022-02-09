package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_bj_11052_카드구매하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[n + 1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i], num);
			
			for(int j = i + 1; j <= n; j++) {
				dp[j] = Math.max(dp[j], dp[j - i] + dp[i]);
			}
		}
		
		System.out.println(dp[n]);
	}

}

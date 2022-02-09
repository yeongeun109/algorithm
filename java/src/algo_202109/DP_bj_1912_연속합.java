package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_bj_1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[n];
		int max = -1000;
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(i == 0)
				dp[i] = num;		
			else if(dp[i - 1] + num >= num)
				dp[i] = dp[i - 1] + num;
			else
				dp[i] = num;
			
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}

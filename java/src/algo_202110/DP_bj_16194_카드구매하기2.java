package algo_202110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_bj_16194_카드구매하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] card = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i = 1; i <= N; i++)
			card[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N + 1];
		dp[1] = card[1];
		
		for(int i = 2; i <= N; i++) {
			dp[i] = card[i];
			
			for(int j = 1; j <= i / 2; j++) {
				dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
			}
		}
		
		System.out.println(dp[N]);
	}

}

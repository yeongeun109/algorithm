package algo_0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj_1010_다리놓기 {
	
	static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			//comb(M, N);
			System.out.println(comb(M, N));
		}
	}

	private static int comb(int n, int r) {
		if(n == r)
			return 1;
		
		if(r == 1)
			return n;
		
		if(dp[n][r] != 0)
			return dp[n][r];
		
		return dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
	}
}

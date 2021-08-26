package algo_0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj_1010_다리놓기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			System.out.println(comb(M, N));
		}
	}

	private static int comb(int n, int r) {
		int res = 1;
		for(int i = 1; i <= r; i++) {
			res = res * (n - i + 1) / i;
		}
		return res;
	}
}

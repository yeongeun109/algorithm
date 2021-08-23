package algo_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_15903_카드합체놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] card = new long[n];
		String str2 = in.readLine();
		StringTokenizer st2 = new StringTokenizer(str2, " ");
		
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st2.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			Arrays.sort(card);
			long sum = card[0] + card[1];
			card[0] = sum;
			card[1] = sum;
		}
		
		long result = 0;
		for(int i = 0; i < n; i++) {
			result += card[i];
		}
		
		System.out.println(result);
	}

}

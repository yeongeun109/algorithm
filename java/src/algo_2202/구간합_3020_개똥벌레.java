package algo_2202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합_3020_개똥벌레 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] ceil = new int[H + 1];
		int[] floor = new int[H + 1];
		
		for(int i = 0; i < N / 2; i++) {
			int num = Integer.parseInt(in.readLine());
			int num2 = Integer.parseInt(in.readLine());
			ceil[num]++;
			floor[num2]++;
		}
		
		for(int i = H - 1; i > 0; i--) {
			ceil[i] += ceil[i + 1];
			floor[i] += floor[i + 1];
		}
		
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		
		for(int i = 1; i <= H; i++) {
			ceil[i] += floor[H - i + 1];
			if(ceil[i] < min) {
				min = ceil[i];
			}
		}
		
		for(int i = 1; i <= H; i++) {
			if(ceil[i] == min)
				cnt++;
		}
		
		System.out.println(min + " " + cnt);
	}

}

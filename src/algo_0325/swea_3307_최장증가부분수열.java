package algo_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			int[] LIS = new int[N];
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				LIS[i] = 1;
				for(int j = 0; j <= i-1; j++) {
					if(arr[j] < arr[i] && LIS[j] + 1 > LIS[i])
						LIS[i] = LIS[j] + 1;
				}
				
				if(LIS[i] > max)
					max = LIS[i];
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}

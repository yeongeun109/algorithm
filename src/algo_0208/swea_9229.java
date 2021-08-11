package algo_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			String str2 = in.readLine();
			StringTokenizer st2 = new StringTokenizer(str2, " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st2.nextToken());
			}
			
			int max = -1;
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					int tempMax = arr[i] + arr[j];
					if(tempMax <= M)
						max = Math.max(max, tempMax);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(max);
			System.out.println(sb);
			max = 0;
		}
	}
}

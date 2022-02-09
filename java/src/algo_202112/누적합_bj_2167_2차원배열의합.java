package algo_202112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 누적합_bj_2167_2차원배열의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][M + 1];
		int[][] sum = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(j == 0)
					sum[i][j] = arr[i][j];
				else
					sum[i][j] = sum[i][j - 1] + arr[i][j];
			}
		}
		
		// 누적합 배열 만들기
		for(int i = 1; i <= M; i++) {
			for(int j = 2; j <= N; j++) {
				sum[j][i] += sum[j - 1][i];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(in.readLine());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int res = sum[x2][y2] - sum[x1 -1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

}

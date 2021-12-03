package algo_202111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_bj_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N + 1][N + 1];
		int cnt = 1;
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j = 1; j <= cnt; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i != 0) {
					arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
				}
			}
			cnt++;
		}
		Arrays.sort(arr[N]);
		System.out.println(arr[N][N]);
	}

}

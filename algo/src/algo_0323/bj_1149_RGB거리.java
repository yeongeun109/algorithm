package algo_0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] cost = new int[N + 1][N];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] linecost = new int[N + 1][N];
		for(int i = 1; i <= N; i++) {
			linecost[i][0] = Math.min(linecost[i-1][1], linecost[i-1][2]) + cost[i][0];
			linecost[i][1] = Math.min(linecost[i-1][0], linecost[i-1][2]) + cost[i][1];
			linecost[i][2] = Math.min(linecost[i-1][0], linecost[i-1][1]) + cost[i][2];
		}
		
		int min = Math.min(linecost[N][0], linecost[N][1]);
		min = Math.min(min, linecost[N][2]);
		System.out.println(min);
	}

}

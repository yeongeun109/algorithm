package algo_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1247_최적경로 {

	static int N;
	static int[] selected;
	static boolean[] visited;
	static int work[];
	static int house[];
	static int con[][];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			selected = new int[N];
			visited = new boolean[N];
			work = new int[2];
			house = new int[2];
			con = new int[N][2];
			
			for(int i = 0; i < 2; i++)
				work[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < 2; i++)
				house[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 2; j++)
					con[i][j] = Integer.parseInt(st.nextToken());
			}
			
			perm(0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(min);
			System.out.println(sb);
			min = Integer.MAX_VALUE;
		}
	}

	private static void perm(int cnt) {
		if(cnt == N) {
			calc(selected);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] == false) {
				selected[cnt] = i;
				visited[i] = true;
				perm(cnt + 1);
				visited[i] = false;
			}
		}
	}

	private static void calc(int[] selected) {
		int sum = 0;
		sum += Math.abs(work[0] - con[selected[0]][0]) + Math.abs(work[1] - con[selected[0]][1]);
		
		for(int i = 0; i < N - 1; i++) {
			sum += Math.abs(con[selected[i]][0] - con[selected[i+1]][0]) + Math.abs(con[selected[i]][1] - con[selected[i+1]][1]);
		}
		
		sum += Math.abs(house[0] - con[selected[N-1]][0]) + Math.abs(house[1] - con[selected[N-1]][1]);
		min = Math.min(min, sum);
	}

}

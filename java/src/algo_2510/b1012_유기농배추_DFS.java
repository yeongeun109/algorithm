package algo_2510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1012_유기농배추_DFS {
	static int res, N, M;
	static int[][] ground;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			res = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int baechuNum = Integer.parseInt(st.nextToken());
			ground = new int[N][M];
			visited = new boolean[N][M];
					
			for(int i = 0; i < baechuNum; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[x][y] = 1;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(ground[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						chkWorm(i, j, 0);
					}
				}
			}
			
			System.out.println(res);
		}
		
	}

	public static void chkWorm(int x, int y, int cnt) {
		if(cnt == 0)
			res++;
		
		for(int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if(cx >= N || cx < 0 || cy >= M || cy < 0 || visited[cx][cy])
				continue;
			
			if(ground[cx][cy] == 1) {
				visited[cx][cy] = true;
				chkWorm(cx, cy, cnt + 1);
			}
		}
	}
}

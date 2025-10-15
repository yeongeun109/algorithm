package algo_2510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class b2178_미로탐색_BFS {
	
	//static boolean[][] visited;
	static int N, M, res = 10000;
	static char[][] miro;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			for(int j = 0; j < M; j++) {
				miro[i][j] = str.charAt(j);
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[0] == N - 1 && tmp[1] == M - 1) {
				res = tmp[2];
				break;
			}
				
			for(int i = 0; i < 4; i++) {
				int cx = tmp[0] + dx[i];
				int cy = tmp[1] + dy[i];
				
				if(cx < 0 || cx >= N || cy < 0 || cy >= M || visited[cx][cy])
					continue;
				
				if(miro[cx][cy] == '1') {
					q.add(new int[] {cx, cy, tmp[2] + 1});
					visited[cx][cy] = true;
				}
			}
		}
		
		System.out.println(res);
	}
	
}

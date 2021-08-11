package algo_0413;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class bj_7576_토마토 {

	static int M, N, alltomato = 0, cnt;
	static int[][] box;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		box = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				box[i][j] = num;
				if(num == 0)
					alltomato++;
				if(num == 1) {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		if(alltomato != 0) {
			bfs();
			if(alltomato == 0)
				System.out.println(cnt);
			else
				System.out.println(-1);
		}else {
			System.out.println(0);
		}
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] temp = q.poll();
				int currX = temp[0];
				int currY = temp[1];
				
				for(int j = 0; j < 4; j++) {
					int tempX = currX + dx[j];
					int tempY = currY + dy[j];
					if(tempX < 0 || tempX == N || tempY < 0 || tempY == M || visited[tempX][tempY] || box[tempX][tempY] == -1)
						continue;
					
					visited[tempX][tempY] = true;
					q.offer(new int[] {tempX, tempY});
					alltomato--;
					if(alltomato == 0)
						return;
				}
			}
		}
	}

}

package algo_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2638_치즈 {

	static int N, M, cheeze;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					arr[i][j] = temp;
					cheeze++;
				}
			}
		}
		
		int cnt = 0;
		while(cheeze != 0) {
			cnt++;
			bfs();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == 2)
						arr[i][j] = 1;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void bfs() {
		int currX = 0;
		int currY = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {currX, currY});
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			currX = temp[0];
			currY = temp[1];
			
			for(int i = 0; i < 4; i++) {
				int tempX = currX + dx[i];
				int tempY = currY + dy[i];
				
				if(tempX == N || tempX < 0 || tempY == M || tempY < 0)
					continue;
				
				if(arr[tempX][tempY] == 2) {
					arr[tempX][tempY] = 0;
					cheeze--;
				}
				
				if(visited[tempX][tempY])
					continue;
				
				if(arr[tempX][tempY] == 1) {
					arr[tempX][tempY]++;
				}else {
					q.offer(new int[] {tempX, tempY});		
				}
				
				visited[tempX][tempY] = true;
			}
		}
	}

}

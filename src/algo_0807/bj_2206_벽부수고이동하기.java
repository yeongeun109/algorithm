package algo_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class bj_2206_벽부수고이동하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int[][] visited = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		visited[0][0] = 0;
		int answer = -1;
		
		q.offer(new int[] {0, 0, 0, 0});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int currX = tmp[0];
			int currY = tmp[1];
			int currCnt = tmp[2];
			
			if(currX == N-1 && currY == M-1) {
				answer = currCnt;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int tmpX = currX + dx[i];
				int tmpY = currY + dy[i];
				if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M || visited[tmpX][tmpY] <= tmp[3])
					continue;
				
				if(arr[tmpX][tmpY] != 1) {
					q.offer(new int[] {tmpX, tmpY, currCnt + 1, tmp[3]});
					visited[tmpX][tmpY] = tmp[3];
				}else {
					if(tmp[3] == 0) {
						q.offer(new int[] {tmpX, tmpY, currCnt + 1, tmp[3]+1});
						visited[tmpX][tmpY] = tmp[3] + 1;
					}
				}
			}
		}
		if(answer != -1)
			System.out.println(answer+1);
		else
			System.out.println(-1);
	}

}

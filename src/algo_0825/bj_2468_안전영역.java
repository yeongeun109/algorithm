package algo_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2468_안전영역 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		int max = 2;
		int min = 100;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}
		}

		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		Queue<int[]> q = new LinkedList<int[]>();
		int res = 1;
		
		for(int h = min; h <= max; h++) {
			boolean[][] visited = new boolean[N][N];
			int areaCnt = 0;
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					if(arr[x][y] > h && !visited[x][y]) {
						areaCnt++;
						q.offer(new int[] {x, y});
						visited[x][y] = true;
						
						while(!q.isEmpty()) {
							int[] tmp = q.poll();
							int currX = tmp[0];
							int currY = tmp[1];
							
							for(int i = 0; i < 4; i++) {
								int tmpX = currX + dx[i];
								int tmpY = currY + dy[i];
								
								if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N || visited[tmpX][tmpY])
									continue;
								
								if(arr[tmpX][tmpY] > h) {
									visited[tmpX][tmpY] = true;
									q.offer(new int[] {tmpX, tmpY});
								}
							}
						}
					}
				}
			}
			res = Math.max(res, areaCnt);
		}
		System.out.println(res);
	}

}

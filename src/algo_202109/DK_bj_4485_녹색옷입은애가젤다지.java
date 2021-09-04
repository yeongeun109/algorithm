package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class DK_bj_4485_녹색옷입은애가젤다지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;

			int[][] arr = new int[N][N];
			int[][] d = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					d[i][j] = Integer.MAX_VALUE;
				}
			}
			
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			q.offer(new int[] {0, 0, arr[0][0]});
			boolean[][] visited = new boolean[N][N];
			visited[0][0] = true;
			int res = 0;
			
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				int currX = tmp[0];
				int currY = tmp[1];
				int currV = tmp[2];
				
				if(currX == N - 1 && currY == N - 1) {
					res = currV;
					break;
				}
				
				for(int i = 0; i < 4; i++) {
					int tmpX = currX + dx[i];
					int tmpY = currY + dy[i];				
					
					if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N || visited[tmpX][tmpY])
						continue;
					
					int tmpV = currV + arr[tmpX][tmpY];
					if(d[tmpX][tmpY] > tmpV) {
						q.offer(new int[] {tmpX, tmpY, tmpV});
						d[tmpX][tmpY] = tmpV;
						visited[tmpX][tmpY] = true;
					}
				}
			}
			System.out.println("Problem " + t++ + ": " + res);
		}
	}

}

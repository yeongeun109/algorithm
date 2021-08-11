package algo_0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class swea_보급로 {

	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, res = Integer.MAX_VALUE;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			res = Integer.MAX_VALUE;
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = in.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - 48;
				}
			}
			visited[0][0] = true;
			bfs(0, 0, 0);
			System.out.println("#" + t + " " + res);
		}
	}

	private static void bfs(int x, int y, int cnt) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		pq.offer(new int[] {x, y, cnt});
		while(!pq.isEmpty()) {
			int[] tmpArr = pq.poll();
			int currX = tmpArr[0];
			int currY = tmpArr[1];
			int currCnt = tmpArr[2];
			
			if(currX == N - 1 && currY == N - 1) {
				res = Math.min(res, currCnt);
			}
			
			
			
			for(int i = 0; i < 4; i++) {
				int tempX = currX + dx[i];
				int tempY = currY + dy[i];
				
				if(tempX < 0 || tempX == N || tempY < 0 || tempY == N || visited[tempX][tempY])
					continue;
				
				visited[tempX][tempY] = true;
				pq.offer(new int[] {tempX, tempY, currCnt + map[tempX][tempY]});
			}
		}
	}

}

package algo_0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17141_연구소2 {

	static int N, M, res = Integer.MAX_VALUE, zero = 0;
	static int[][] arr;
	static List<int[]> avail = new ArrayList<int[]>();
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2)
					avail.add(new int[] {i, j});
				else if(arr[i][j] == 0)
					zero++;
			}
		}
		selected = new boolean[avail.size()];
		if(zero + (avail.size() - M) == 0)
			System.out.println(0);
		else {
			comb(0, 0);
			if(res == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(res);
		}
	}

	private static void comb(int cnt, int start) {
		if(cnt == M) {
			int[] virus = new int[M];
			int idx = 0;
			for(int i = 0; i < avail.size(); i++) {
				if(selected[i])
					virus[idx++] = i;
			}
			
			int[][] tmp = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					tmp[i][j] = arr[i][j];
			}
			bfs(virus, tmp);
			return;
		}
		
		for(int i = start; i < avail.size(); i++) {
			selected[i] = true;
			comb(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

	private static void bfs(int[] currV, int[][] tmpArr) {
		boolean[][] visited = new boolean[N][N];
		int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
		int tmpZero = zero + (avail.size() - M);	
		int cnt = 0;
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i = 0; i < M; i++) {
			q.offer(new int[] {avail.get(currV[i])[0], avail.get(currV[i])[1]});
			visited[avail.get(currV[i])[0]][avail.get(currV[i])[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			boolean flag = false;
			
			for(int i = 0; i < size; i++) {
				int[] tmp = q.poll();
				int currX = tmp[0];
				int currY = tmp[1];
				
				tmpArr[currX][currY] = 3;
				
				for(int j = 0; j < 4; j++) {
					int tmpX = currX + dx[j];
					int tmpY = currY + dy[j];
					
					if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N || visited[tmpX][tmpY] || tmpArr[tmpX][tmpY] == 1)
						continue;
					
					q.offer(new int[] {tmpX, tmpY});
					tmpZero--;
					visited[tmpX][tmpY] = true;
					if(tmpZero == 0) {
						flag = true;
						break;
					}
				}
				
				if(flag)
					break;
			}
			cnt++;
			if(flag)
				break;
		}

		if(tmpZero == 0)
			res = Math.min(res, cnt);
	}

}

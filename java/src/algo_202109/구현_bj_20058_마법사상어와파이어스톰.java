package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구현_bj_20058_마법사상어와파이어스톰 {

	static int[][] arr;
	static int n, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		n = (int) Math.pow(2, N);
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			int diff = N - L;

			divide(new int[] {0,0}, new int[] {n-1, n-1}, diff, 0, n);
			check();
		}
		
		System.out.println(count());
		System.out.println(biggest());
	}

	private static int biggest() {
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<int[]>();
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] > 0 && !visited[i][j]) {
					q.add(new int[] {i,j});
					visited[i][j] = true;
					int cnt = 1;
					
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						int cx = tmp[0];
						int cy = tmp[1];
						
						for(int k = 0; k < 4; k++) {
							int tx = cx + dx[k];
							int ty = cy + dy[k];
							if(tx < 0 || tx >= n || ty < 0 || ty >= n || visited[tx][ty])
								continue;
							
							if(arr[tx][ty] > 0) {
								q.add(new int[] {tx, ty});
								cnt++;
								visited[tx][ty] = true;
							}
						}
					}
					max = Math.max(max, cnt);
				}
			}
		}
		return max;
	}

	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	private static void check() {
		int[][] tmp = new int[n][n];
		for(int x = 0; x < n; x++) {
			for(int j = 0; j <n; j++)
				tmp[x][j] = arr[x][j];
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int cnt = 0;
				for(int k = 0; k < 4; k++) {
					int tx = i + dx[k];
					int ty = j + dy[k];
					if(tx < 0 || tx >= n || ty < 0 || ty >= n)
						continue;
					
					if(tmp[tx][ty] > 0)
						cnt++;
				}
				
				if(cnt < 3)
					arr[i][j]--;
			}
		}
	}

	private static int count() {
		int res = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] > 0)
					res += arr[i][j];
			}
		}
		return res;
	}

	public static void divide(int[] begin, int[] end, int diff, int cnt, int size) {
		if(cnt == diff) {
			int[][] t = new int[size][size];
			int x = begin[0], y = begin[1];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					t[i][j] = arr[x][y++];
				}
				y = begin[1];
				x++;
			}
			
			int[][] t2 = new int[size][size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					t2[i][j] = t[i][j];
				}
			}
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					t[i][j] = t2[size-1-j][i];
				}
			}

			x = 0; y = 0;
			for(int i = begin[0]; i <= end[0]; i++) {
				for(int j = begin[1]; j <= end[1]; j++) {
					arr[i][j] = t[x][y++];
				}
				x++;
				y = 0;
			}
			
			return;
		}
		
		divide(new int[] {begin[0], begin[1]}, new int[] {(begin[0] + end[0]) / 2, (begin[1] + end[1]) / 2}, diff, cnt + 1, size/2);
		divide(new int[] {begin[0], begin[1] + size / 2}, new int[] {(begin[0] + end[0])/2, end[1]}, diff, cnt + 1, size/2);
		divide(new int[] {begin[0] + size / 2, begin[1]}, new int[] {end[0], (begin[1] + end[1])/2}, diff, cnt + 1, size/2);
		divide(new int[] {begin[0] + size / 2, begin[1] + size / 2}, new int[] {end[0], end[1]}, diff, cnt + 1, size/2);
	}
}

/*
3 1
1 2 3 4 5 6 7 8
9 10 11 12 13 14 15 16
17 18 19 20 21 22 23 24
25 26 27 28 29 30 31 32
33 34 35 36 37 38 39 40
41 42 43 44 45 46 47 48
49 50 51 52 53 54 55 56
57 58 59 60 61 62 63 64
1
*/
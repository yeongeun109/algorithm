package algo_2510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b14502_연구소_BFS {
	static int[][] arr;
	static int N, M, res = 0;
	static int[][] threeWalls = new int[3][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		ArrayList<int[]> zeroList = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0)
					zeroList.add(new int[] {i, j});
			}
		}
		
		make3Walls(zeroList, 0, 0);
		System.out.println(res);
	}
	
	static public void make3Walls(ArrayList<int[]> zeroList, int cnt, int start) {
		if(cnt == 3) {
			int safeArea = calcSafeArea(threeWalls);
			res = Math.max(safeArea, res);
			return;
		}
		
		for(int i = start; i < zeroList.size(); i++) {
			threeWalls[cnt] = zeroList.get(i);
			make3Walls(zeroList, cnt + 1, i + 1);
		}
		
	}
	
	static public int calcSafeArea(int[][] _threeWalls) {
		int safeArea = 0;
		int[][] tmpArr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmpArr[i][j] = arr[i][j];
			}
		}
		
		for(int i = 0; i < 3; i++) {
			tmpArr[_threeWalls[i][0]][_threeWalls[i][1]] = 1;
		}
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		Queue<int[]> q = new LinkedList<int[]>(); // 이동할 수 있는 칸
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && tmpArr[i][j] == 2) {
					q.offer(new int[] {i, j});
					
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						int cx = tmp[0];
						int cy = tmp[1];
								
						for(int k = 0; k < 4; k++) {
							int tx = cx + dx[k];
							int ty = cy + dy[k];
							
							if(tx < 0 || tx >= N || ty < 0 || ty >= M || visited[tx][ty])
								continue;
							
							if(tmpArr[tx][ty] == 0) {
								tmpArr[tx][ty] = 2;
								q.offer(new int[] {tx, ty});
								visited[i][j] = true;
							}
						}
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmpArr[i][j] == 0)
					safeArea++;
			}
		}
		
		return safeArea;
	}
}

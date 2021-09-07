package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 구현_bj_14500_테트로미노 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dx = {
				{0,1,1},
				{1,2,3}, {0,0,0},
				{1,2,2}, {1,2,2}, {0,1,2}, {0,1,2},
				{1,1,2}, {1,1,2}, {0,1,1}, {0,1,1},
				{0,0,1}, {1,1,1}, {1,1,2}, {1,1,2},
				{1,1,1}, {1,1,1}, {0,0,1}, {0,0,1}
		};
		
		int[][] dy = {
				{1,0,1},
				{0,0,0}, {1,2,3},
				{0,0,1}, {0,0,-1}, {1,0,0}, {1,1,1},
				{0,1,1}, {-1,0,-1}, {1,1,2}, {-1,-1,-2},
				{1,2,1}, {-1,0,1}, {-1,0,0}, {0,1,0},
				{0,1,2}, {-2,-1,0}, {1,2,0}, {1,2,2}
		};
		
		ArrayList<int[]>[] xlist = new ArrayList[6];
		ArrayList<int[]>[] ylist = new ArrayList[6];
		for(int i = 0; i < 6; i++) {
			xlist[i] = new ArrayList<int[]>();
			ylist[i] = new ArrayList<int[]>();
		}
		xlist[0].add(dx[0]); ylist[0].add(dy[0]);
		xlist[1].add(dx[1]); xlist[1].add(dx[2]); ylist[1].add(dy[1]); ylist[1].add(dy[2]);
		for(int i = 3; i < 7; i++) {
			xlist[2].add(dx[i]);
			ylist[2].add(dy[i]);
		}
		
		for(int i = 7; i < 11; i++) {
			xlist[3].add(dx[i]);
			ylist[3].add(dy[i]);
		}
		
		for(int i = 11; i < 15; i++) {
			xlist[4].add(dx[i]);
			ylist[4].add(dy[i]);
		}
		
		for(int i = 15; i < 19; i++) {
			xlist[5].add(dx[i]);
			ylist[5].add(dy[i]);
		}
		
		int res = 0;
		
		for (int k = 0; k < 6; k++) {
			for (int l = 0; l < xlist[k].size(); l++) {
				int[] xdir = xlist[k].get(l);
				int[] ydir = ylist[k].get(l);
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						int cnt = arr[i][j];
						for(int m = 0; m < 3; m++) {
							int tx = i + xdir[m];
							int ty = j + ydir[m];
							
							if(tx < 0 || tx >= N || ty < 0 || ty >= M)
								break;
							
							cnt += arr[tx][ty];
						}
						res = Math.max(res, cnt);
					}
				}
			}
		}
		
		System.out.println(res);
	}

}

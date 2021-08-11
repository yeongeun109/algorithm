package algo_0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_2583_영역구하기 {

	static int M, N, cnt;
	static boolean[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new boolean[M][N];
		for(int k = 0; k < K; k++) {
			StringTokenizer st2 = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st2.nextToken());
			int y1 = Integer.parseInt(st2.nextToken());
			int x2 = Integer.parseInt(st2.nextToken());
			int y2 = Integer.parseInt(st2.nextToken());
			
			for(int i = y1; i < y2; i++) {
				for(int j = x1; j < x2; j++) {
					
					arr[i][j] = true;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == false) {
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
				}
				
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	private static void dfs(int i, int j) {
		if(arr[i][j] == false) {
			cnt++;
			arr[i][j] = true;
		}
		
		for(int x = 0; x < 4; x++) {
			if(i + dx[x] < 0 || i + dx[x] >= M || j + dy[x] < 0 || j + dy[x] >= N) {
				continue;
			}else {
				if(arr[i + dx[x]][j + dy[x]] == false)
					dfs(i + dx[x], j + dy[x]);
				else {
					continue;
				}
			}
		}
	}
}

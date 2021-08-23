package algo_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class bj_2667_단지번호붙이기 {

	static boolean[][] visited;
	static int homes = 0;
	static ArrayList<Integer> homelist = new ArrayList<Integer>();
	static int[][] arr;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());		
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String st = in.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = st.charAt(j) - '0';
				if(arr[i][j] == 1)
					homes++;
			}
		}
		
		int x = 0, y = 0;
		while(homes != 0) {
			for(int i = 0; i < N; i++) {
				boolean flag = false;
				for(int j = 0; j < N; j++) {					
					if(arr[i][j] == 1 && !visited[i][j]) {
						x = i;
						y = j;
						bfs(x, y);
						flag = true;
						break;
					}else
						visited[i][j] = true;
				}
				if(flag)
					break;
			}
		}
		System.out.println(homelist.size());
		Collections.sort(homelist);
		for(int i = 0; i < homelist.size(); i++)
			System.out.println(homelist.get(i));
	}

	private static void bfs(int x, int y) {
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		homes -= 1;
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int currX = tmp[0];
			int currY = tmp[1];
			
			for(int i = 0; i < 4; i++) {
				int tmpX = currX + dx[i];
				int tmpY = currY + dy[i];
				
				if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N || visited[tmpX][tmpY])
					continue;
				
				if(arr[tmpX][tmpY] == 1) {
					q.offer(new int[] {tmpX, tmpY});
					visited[tmpX][tmpY] = true;
					homes--;
					cnt++;
				}
			}
		}
		homelist.add(cnt);
	}

}

package algo_202108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_bj_11559_PuyoPuyo {

	static char[][] arr = new char[12][6];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 12; i++) {
			arr[i] = in.readLine().toCharArray();
		}
		
		int res = 0;
		while(bfs()) {
			res++;
		}
		
		System.out.println(res);
	}

	static public boolean bfs() {
		boolean flag = false;
		boolean[][] visited = new boolean[12][6];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		visited[0][0] = true;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0 , -1, 0};
		
		for(int x = 0; x < 12; x++) {
			for(int y = 0; y < 6; y++) {
				if(arr[x][y] != '.' && !visited[x][y]) {
					q.offer(new int[] {x, y});
					visited[x][y] = true;
					char c = arr[x][y];
					int critical = 1;
					List<int[]> list = new ArrayList<>();
					list.add(new int[] {x, y});
					
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						int currX = tmp[0];
						int currY = tmp[1];
						
						for(int i = 0; i < 4; i++) {
							int tmpX = currX + dx[i];
							int tmpY = currY + dy[i];
							
							if(tmpX < 0 || tmpX >= 12 || tmpY < 0 || tmpY >= 6 || visited[tmpX][tmpY])
								continue;
							
							if(arr[tmpX][tmpY] == c) {
								q.offer(new int[] {tmpX, tmpY});
								visited[tmpX][tmpY] = true;
								critical++;
								list.add(new int[] {tmpX, tmpY});
							}
						}
					}
					
					if(critical >= 4) {
						flag = true;
						makeDot(list);
					}
				}
			}
		}
		
		goDown();	
		
		return flag;
	}

	private static void goDown() {
		for(int j = 0; j < 6; j++) {
			Queue<Character> q = new LinkedList<>();
			for(int i = 11; i >= 0; i--) {
				if(arr[i][j] != '.') {
					q.add(arr[i][j]);
				}
			}
			
			int idx = 11;
			while(!q.isEmpty()) {
				arr[idx][j] = q.poll();
				idx--;
			}
			
			for(int i = idx; i >= 0; i--) {
				arr[i][j] = '.';
			}
		}
	}

	private static void makeDot(List<int[]> list) {
		for(int i = 0; i < list.size(); i++) {
			arr[list.get(i)[0]][list.get(i)[1]] = '.';
		}
	}
}

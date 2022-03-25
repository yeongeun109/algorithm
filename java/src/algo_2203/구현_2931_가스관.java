package algo_2203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구현_2931_가스관 {
	
	static char[][] map;
	static int R, C, mx = 0, my = 0, zx = 0, zy = 0, totalCnt = 0;
	static char[] clist = {'|', '-', '+', '1', '2', '3', '4'};
	
	public static class Pipe{
		int x;
		int y;
		int d;
		int cnt;
		
		public Pipe(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		findRC();

		for(int i = 0; i < R; i++) {
			boolean flag = false;
			for(int j = 0; j < C; j++) {
				if(map[i][j] == '.') {
					for(int k = 0; k < 7; k++) {
						map[i][j] = clist[k];
						for(int l = 0; l < 4; l++) {
							if(goBfs(l) == totalCnt + 1) {
								System.out.println((i+1) + " " + (j+1) + " " + clist[k]);
								flag = true;
								break;
							}
						}
						
						if(flag)
							break;
						map[i][j] = '.';
					}
				}
				if(flag)
					break;
			}
			if(flag)
				break;
		}
		
	}
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	private static int goBfs(int d) {
		Queue<Pipe> q = new LinkedList<>();
		q.add(new Pipe(mx, my, d, 0));
		boolean[][] visited = new boolean[R][C];
		visited[mx][my] = true;
		
		while(!q.isEmpty()) {
			Pipe tmp = q.poll();
			int cx = tmp.x;
			int cy = tmp.y;
			int cnt = tmp.cnt;
			
			if(cx == zx && cy == zy) {
				return cnt - 1;
			}
			
			int tx = cx + dx[d];
			int ty = cy + dy[d];
			
			if(tx < 0 || tx >= R || ty < 0 || ty >= C || map[tx][ty] == '.')
				continue;
			
			switch(map[tx][ty]) {
			case '|':
				if(d == 0 || d == 2)
					return -1;
				break;
			case '-':
				if(d == 1 || d == 3)
					return -1;
				break;
			case '+':
				break;
			case '1':
				if(d == 3)
					d = 0;
				else if(d == 2)
					d = 1;
				else
					return -1;
				break;
			case '2':
				if(d == 1)
					d = 0;
				else if(d == 2)
					d = 3;
				else
					return -1;
				break;
			case '3':
				if(d == 0)
					d = 3;
				else if(d == 1)
					d = 2;
				else
					return -1;
				break;
			case '4':
				if(d == 0)
					d = 1;
				else if(d == 3)
					d = 2;
				else
					return -1;
				break;
			}
			
			if(visited[tx][ty])
				q.offer(new Pipe(tx, ty, d, cnt));
			else {
				q.offer(new Pipe(tx, ty, d, cnt + 1));
				visited[tx][ty] = true;
			}
				
		}
		return -1;
	}

	private static void findRC() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 'M') {
					mx = i;
					my = j;
				}else if(map[i][j] == 'Z') {
					zx = i;
					zy = j;
				}else if(map[i][j] != '.')
					totalCnt++;
			}
		}
	}
}
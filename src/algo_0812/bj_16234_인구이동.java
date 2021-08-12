package algo_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16234_인구이동 {

	static int N;
	static int prevCnt = 0, prevPop = 0, prevAvg = 0;
	static boolean[][] prevArr;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		prevArr = new boolean[N][N];
		//check = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while(true) {
			if(!bfs(L, R))
				break;
			else {
				cnt++;
				
			}
		}
		System.out.println(cnt);
	}

	private static boolean bfs(int L, int R) {
		boolean flag = false;
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				
				q.offer(new int[] {i,j});
				
				int cCnt = 0;
				int pCnt = 0;
				int avg = 0;
				List<int[]> list = new ArrayList<int[]>();
				
				while(!q.isEmpty()) {
					int[] tmp = q.poll();
					int currX = tmp[0];
					int currY = tmp[1];
					
					for(int k = 0; k < 4; k++) {
						int tmpX = currX + dx[k];
						int tmpY = currY + dy[k];
						
						if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N || visited[tmpX][tmpY])
							continue;
						
						int diff = Math.abs(arr[currX][currY] - arr[tmpX][tmpY]);
						if(diff >= L && diff <= R) {
							if(!visited[currX][currY]) {
								visited[currX][currY] = true;
								visited[tmpX][tmpY] = true;
								cCnt += 2;
								pCnt += arr[currX][currY] + arr[tmpX][tmpY];
								list.add(new int[] {currX, currY});
								list.add(new int[] {tmpX, tmpY});
							}else {
								visited[tmpX][tmpY] = true;
								cCnt += 1;
								pCnt += arr[tmpX][tmpY];
								list.add(new int[] {tmpX, tmpY});
							}
							flag = true;
							q.offer(new int[] {tmpX, tmpY});
						}
					}
				}
				
				if(cCnt != 0) {
					avg = pCnt / cCnt;
				}
				
				for(int k = 0; k < list.size(); k++) {
					int x = list.get(k)[0];
					int y = list.get(k)[1];
					arr[x][y] = avg;
				}
			}
		}
		
		
		return flag;
	}

}

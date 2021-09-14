package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_bj_14502_연구소 {

	static int N, M, res = 0;
	static int[][] selected = new int[3][2];
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		ArrayList<int[]> zerolist = new ArrayList<int[]>(); 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0)
					zerolist.add(new int[] {i, j});
			}
		}
		
		comb(zerolist, 0, 0);
		//int safe = calcSafe(new int[] {}, arr);
		//System.out.println(safe);
		System.out.println(res);
	}
	
	public static void comb(ArrayList<int[]> zerolist, int cnt, int start) {
		if(cnt == 3) {
//			for(int i = 0; i < 3; i++) {
//				System.out.print(Arrays.toString(selected[i]) + " | ");
//			}
			//System.out.println();
			
			int safe = calcSafe(selected);
			res = Math.max(res, safe);
			return;
		}
		
		for(int i = start; i < zerolist.size(); i++) {
			selected[cnt] = zerolist.get(i);
			comb(zerolist, cnt + 1, i + 1);
		}
	}

	private static int calcSafe(int[][] wall) {
		int[][] tmpArr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmpArr[i][j] = arr[i][j];
			}
		}
		
		for(int i = 0; i < 3; i++) {
			tmpArr[wall[i][0]][wall[i][1]] = 1;
		}
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				boolean flag = true;
				int tcnt = 0;
				if(!visited[i][j] && tmpArr[i][j] == 2) {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						int cx = tmp[0];
						int cy = tmp[1];
						
						for(int k = 0; k < 4; k++) {
							int tx = cx + dx[k];
							int ty = cy + dy[k];
							
							if(tx < 0 || tx >= N || ty < 0 || ty >= M || visited[tx][ty])
								continue;
							
//							if(tmpArr[tx][ty] == 2) {
//								flag = false;
//								break;
//							}else
								if(tmpArr[tx][ty] == 0) {
									tmpArr[tx][ty] = 2;
								//tcnt++;
								q.offer(new int[] {tx, ty});
								visited[tx][ty] = true;
							}
						}
						
//						if(!flag)
//							break;
					}
				}
				
//				if(flag)
//					cnt += tcnt;
			}
		}
		
//		for(int i = 0; i < N; i++)
//			System.out.println(Arrays.toString(tmpArr[i]));
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmpArr[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

}

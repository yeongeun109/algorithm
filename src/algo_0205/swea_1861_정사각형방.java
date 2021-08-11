package algo_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1861_정사각형방 {

	static int[] dx = {-1,1,0,0}; 
	static int[] dy = {0,0,1,-1};
	static int[] max = new int[2];
	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(in.readLine());
			int arr[][] = new int[N+2][N+2];
			boolean visited[][] = new boolean[N+2][N+2];
			max[0] = 0; max[1] = N*N;
			
			for(int i = 1; i < N+1; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				
				for(int j = 1; j < N+1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++) {
					cnt = 0;
					int tempMax = max[0];
					
					if(visited[i][j] != true) {
						search(i, j, arr, visited);
					
						if(cnt != 0) {
							if(cnt == tempMax) {
								if(max[1] > arr[i][j])
									max[1] = arr[i][j];
							}else if(cnt > tempMax) {
								max[1] = arr[i][j];
							}
						}
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t+1).append(" ").append(max[1]).append(" ").append(max[0] + 1);
			System.out.println(sb);
		}
	}

	private static void search(int x, int y, int[][] arr, boolean[][] visited) {
		boolean flag = false;
		visited[x][y] = true;
		
		for(int k = 0; k < 4; k++) {
			if(arr[x+dx[k]][y+dy[k]] == arr[x][y] + 1) {
				
				x = x+dx[k]; 
				y = y+dy[k];
				
				flag = true;
				break;
			}		
		}
		
		if(flag == true) {
			cnt++;
			search(x, y, arr, visited);
		}
		else {
			if(cnt > max[0]) {
				max[0] = cnt;
			}
			return;
		}
	}
	
}

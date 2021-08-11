package algo_0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_4963_섬의개수 {
	static int w;
	static int h;
	static int oneNum, cnt, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st1 = new StringTokenizer(in.readLine(), " ");
			w = Integer.parseInt(st1.nextToken());
			h = Integer.parseInt(st1.nextToken());
			cnt = 0;
			oneNum = 0;
			result = 0;
			
			if(w == 0 && h == 0) {
				break;
			}
			
			boolean[][] arr = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				StringTokenizer st2 = new StringTokenizer(in.readLine(), " ");
				for(int j = 0; j < w; j++) {
					if(Integer.parseInt(st2.nextToken()) == 1) {
						arr[i][j] = true;
						oneNum++;
					}
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(arr[i][j] == true) {
						result++;
						dfs(i, j, arr);
					}
					
				}
			}
			System.out.println(result);
		}
	}

	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	private static void dfs(int i, int j, boolean[][] arr) {
		if(cnt == oneNum) {
			return;
		}
		
		if(arr[i][j] == true) {
			cnt++;
			arr[i][j] = false;
		}
		
		for(int x = 0; x < 8; x++) {
			if(i + dx[x] < 0 || i + dx[x] >= h || j + dy[x] < 0 || j + dy[x] >= w) {
				continue;
			}else {
				if(arr[i + dx[x]][j + dy[x]] == true)
					dfs(i + dx[x], j + dy[x], arr);
				else {
					continue;
				}
			}
		}
	}

}

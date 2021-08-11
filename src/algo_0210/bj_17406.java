package algo_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_17406 {

	static int[][] arr;
	static int N;
	static int M;
	static int K;
	static boolean visited[];
	static int[] selected;
	static int[][] rotArr;
	static int resMin;
	static int result[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str1 = in.readLine();
		StringTokenizer st1 = new StringTokenizer(str1, " ");
		N = Integer.parseInt(st1.nextToken()); 
		M = Integer.parseInt(st1.nextToken());
		K = Integer.parseInt(st1.nextToken()); //È¸ÀüÈ½¼ö
		arr = new int[N+2][M+2];
		visited = new boolean[K+1];
		rotArr = new int[K][3];
		selected = new int[K];
		
		for(int i = 1; i < N+1; i++) {
			String str2 = in.readLine();
			StringTokenizer st2 = new StringTokenizer(str2, " ");
			for(int j = 1; j < M+1; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			String str3 = in.readLine();
			StringTokenizer st3 = new StringTokenizer(str3, " ");
			for(int j = 0; j < 3; j++) {
				rotArr[i][j] = Integer.parseInt(st3.nextToken());
			}
		}
		resMin = 100 * M;
		perm(0);
		System.out.println(resMin);
	}

	private static void rotate(int[] currRot, int[][] tempArr) {
		int r = currRot[0];
		int c = currRot[1];
		int s = currRot[2];
		int x, y, maxX, maxY;
		int T = (2*s+1) / 2;

		for(int t = 0; t < T; t++) {
			x = r+s; maxX = r-s;
			y = c+s;
			int temp = tempArr[x][y];
			for(int i = x; i > maxX; i--) {
				tempArr[i][y] = tempArr[i-1][y];
			}
			
			x = r-s;
			maxY = c-s;
			for(int i = y; i > maxY; i--) {
				tempArr[x][i] = tempArr[x][i-1];
			}
			
			
			y = c-s;
			maxX = r+s;
			for(int i = x; i < maxX; i++) {
				tempArr[i][y] = tempArr[i+1][y];
			}
			
			x = r+s;
			maxY = c+s;
			for(int i = y; i < maxY; i++) {
				tempArr[x][i] = tempArr[x][i+1];
			}
			
			tempArr[x][maxY-1] = temp;
			s--;
		}
		
		return;
	}

	private static int minRow(int[][] tempArr) {
		int min = 100 * M;
		
		for(int i = 1; i <= N; i++) {
			int temp = 0;
			for(int j = 1; j <= M; j++) {
				temp += tempArr[i][j];
			}
			min = Math.min(min, temp);
		}
		
		return min;
	}

	private static void perm(int currIdx) {
		if(currIdx == K) {
			int[][] tempArr = new int[N+2][M+2];
			for(int x = 1; x <= N; x++) {
				for(int y = 1; y <= M; y++) {
					tempArr[x][y] = arr[x][y];
				}
			}
			
			for(int i = 0; i < K; i++) {
				rotate(rotArr[selected[i]], tempArr);
			}
			resMin = Math.min(minRow(tempArr), resMin);
			return;
		}
		
		for(int i = 1; i <= K; i++) {
			if(visited[i] == false) {
				selected[currIdx] = i-1;
				visited[i] = true;
				perm(currIdx+1);
				visited[i] = false;
			}else
				continue;
		}
	}
}

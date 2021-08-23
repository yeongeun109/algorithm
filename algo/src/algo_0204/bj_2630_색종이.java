package algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2630_색종이 {
	
	static int[][] arr;
	static int blue = 0;
	static int white = 0;
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st  = new StringTokenizer(str, " " );
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cutPaper(new int[] {0,0}, new int[] {N,N}, N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void cutPaper(int[] startIdx, int[] endIdx, int arrSize) {
		if(arrSize == 1) {
			if(arr[startIdx[0]][startIdx[1]] == 0)
				white++;
			else
				blue++;
			return;
		}
		
		int color = arr[startIdx[0]][startIdx[1]];
		boolean flag = false;
		int x = startIdx[0];
		int y = startIdx[1];
		
		while(x < endIdx[0]) {
			while(y < endIdx[1]) {
				if(arr[x][y] != color) {
					flag = true;
					break;
				}
				y++;
			}
			if(flag == true)
				break;
			x++;
			y = startIdx[1];
		}
		
		if(flag == true) {
			for(int i = startIdx[0]; i < endIdx[0]; i += arrSize/2) {
				for(int j = startIdx[1]; j < endIdx[1]; j += arrSize/2) {
					cutPaper(new int[] {i,j}, new int[] {i+arrSize/2, j+arrSize/2}, arrSize/2);
				}
			}
		}else {
			if(color == 0)
				white++;
			else
				blue++;
			return;
		}
		
	}
	
}

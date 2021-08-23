package algo_0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1992_쿼드트리 {

	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		StringBuilder sb = new StringBuilder();
		quad(0, 0, N, sb);
		System.out.println(sb);
	}

	private static void quad(int x, int y, int size, StringBuilder sb) {
		if(size == 1) {
			sb.append(arr[x][y]);
			return;
		}
		
		int firstNum = arr[x][y];
		boolean flag = false;
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(arr[i][j] != firstNum) {
					flag = true;
					break;
				}
			}
			if(flag == true)
				break;
		}
		
		if(flag == true) {
			sb.append("(");
			quad(x, y, size/2, sb);
			quad(x, y+size/2, size/2, sb);
			quad(x+size/2, y, size/2, sb);
			quad(x+size/2, y+size/2, size/2, sb);
			sb.append(")");
		}else {
			sb.append(firstNum);
		}
	}
}

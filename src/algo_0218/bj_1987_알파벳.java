package algo_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1987_알파벳 {

	static char[][] arr;
	static boolean[] alpha = new boolean[26];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int R, C, cnt, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			arr[i] = in.readLine().toCharArray();
		}
		
		alpha[arr[0][0] - 65] = true;
		check(0, 0);
		System.out.println(max + 1);
	}

	private static void check(int x, int y) {
		boolean flag = false;
		
		for(int i = 0; i < 4; i++) {
			if(x + dx[i] >= 0 && x + dx[i] < R && y + dy[i] >= 0 && y + dy[i] < C) {
				if(alpha[arr[x + dx[i]][y + dy[i]] - 65] == false) {
					flag = true;
					cnt++;
					alpha[arr[x + dx[i]][y + dy[i]] - 65] = true;
					check(x + dx[i], y + dy[i]);
					alpha[arr[x + dx[i]][y + dy[i]] - 65] = false;
					cnt--;
				}
			}
		}
		
		if(flag == false) {
			max = Math.max(cnt, max);
		}
	}

}

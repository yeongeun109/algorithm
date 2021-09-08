package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시뮬_bj_14499_주사위굴리기 {

	static int[] dice = new int[6];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < K; i++) {
			int dirc = Integer.parseInt(st.nextToken());
			int tx = x + dx[dirc - 1];
			int ty = y + dy[dirc - 1];
			
			if(tx < 0 || tx >= N || ty < 0 || ty >= M)
				continue;
			
			x = tx;
			y = ty;
			roll(dirc);
			
			if(arr[x][y] == 0)
				arr[x][y] = dice[5];
			else {
				dice[5] = arr[x][y];
				arr[x][y] = 0;
			}
			sb.append(dice[0] + "\n");
		}
		System.out.println(sb);
	}
	
	static public void roll(int dirc) {
		int[] tmp = new int[6];
		for(int i = 0; i < 6; i++) {
			tmp[i] = dice[i];
		}
		
		if(dirc == 1) {
			dice[0] = tmp[3];
			dice[2] = tmp[0];
			dice[3] = tmp[5];
			dice[5] = tmp[2];
		}else if(dirc == 2) {
			dice[0] = tmp[2];
			dice[3] = tmp[0];
			dice[2] = tmp[5];
			dice[5] = tmp[3];
		}else if(dirc == 3) {
			dice[0] = tmp[4];
			dice[1] = tmp[0];
			dice[4] = tmp[5];
			dice[5] = tmp[1];
		}else {
			dice[0] = tmp[1];
			dice[1] = tmp[5];
			dice[4] = tmp[0];
			dice[5] = tmp[4];
		}
	}

}

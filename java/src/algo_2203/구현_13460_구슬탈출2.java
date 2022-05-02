package algo_2203;

import java.io.*;
import java.util.StringTokenizer;

public class 구현_13460_구슬탈출2 {

	static char[][] map;
	static int[] red = new int[2];
	static int[] blue = new int[2];
	static int[] hole = new int[2];
	
	public static void main(String[] args) throws IOException {
		// R과 B가 동시에 둘 다 빠져나가면 실패
		// 10번 이상이면 실패
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
				}else if(map[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
				}else if(map[i][j] == 'O') {
					hole[0] = i;
					hole[1] = j;
				}
			}
		}
		
		
	}

}

package algo_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4014_활주로건설 {

	static int N, X;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken()); // 경사로 길이
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			
			cnt = count(map, cnt);
			
			for(int i = 0; i < N; i++) {
				for(int j = i; j < N; j++) {
					int temp = map[i][j];
					map[i][j] = map[j][i];
					map[j][i] = temp;
				}
			}
			
			cnt = count(map, cnt);
			
			System.out.println("#" + t + " " + cnt);
		}
	}

	private static int count(int[][] map, int cnt) {
		for(int i = 0; i < N; i++) {
			if(makeRoad(map[i]))
				cnt++;
		}
		return cnt;
	}

	private static boolean makeRoad(int[] is) {
		int beforeHeight = is[0];
		int size = 0;
		int j = 0; //탐색열 위치
		while(j < N) {
			if(beforeHeight == is[j]) {
				++size;
				++j;
			}else if(beforeHeight + 1 == is[j]) { // 오르막 경사로 설치 가능한지 판단
				if(size < X)
					return false; // 경사로 설치 불가
				beforeHeight++;
				size = 1;
				++j;
			}else if(beforeHeight - 1 == is[j]) { // 내리막 경사로 설치 가능한지 판단
				int count = 0;
				for(int k = j; k < N; k++) {
					if(is[k] != beforeHeight - 1)
						break;
					if(++count == X)
						break;
				}
				
				if(count < X)
					return false; // 경사로 설치 불가
				beforeHeight--;
				size = 0;
				j += X;
			}else {
				return false;
			}
		}
		return true;
	}

}
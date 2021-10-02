package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 완탐_bj_15684_사다리조작_미해결 {

	static int N, M, H;
	static boolean[][] _tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		_tmp = new boolean[11][31];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			_tmp[b][a] = true;
		}
//		for(int i = 0; i < H; i++)
//			System.out.println(Arrays.toString(arr[i]));
		check(0);
		dfs(0, 1);
		if(min == Integer.MAX_VALUE || min > 3)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void dfs(int cnt, int h) {
		if(cnt == M) {
			return;
		}
		
		for(int i = h; i <= H; i++) {
			for(int j = 1; j < N; j++) {
//				if(j > 0 && _tmp[i][j - 1])
//					continue;
//				if(_tmp[i][j]) {
//					if(j + 1 < N - 1)
//						j++;
//					continue;
//				}
//				if(j < N - 1 && _tmp[i][j + 1]) {
//					if(j + 2 < N - 1)
//						j += 2;
//					continue;
//				}
				if(_tmp[j][i])
					continue;
				if(_tmp[j - 1][i])
					continue;
				if(_tmp[j + 1][i])
					continue;
				
				_tmp[i][j] = true;
				check(cnt + 1);
				dfs(cnt + 1, i);
				_tmp[i][j] = false;
			}
		}
	}

	static int min = Integer.MAX_VALUE;
	private static void check(int cnt) {
		boolean flag = true;
		for(int i = 1; i <= N; i++) {
			int line = i;
			for(int j = 1; j <= H; j++) {
				if(_tmp[j][line])
					line++;
				else if(_tmp[j][line-1])
					line--;
//				if(line > 0) {
//					if(_tmp[j][line - 1]) {
//						line--;
//						continue;
//					}
//				}
//				if(_tmp[j][line]) {
//					line++;
//					continue;
//				}
			}
			//System.out.println(i + "라인 : " + line);
			if(i != line) {
				flag = false;
				break;
			}
		}
		System.out.println(flag);
		if(flag) {
//			System.out.println(cnt);
			min = Math.min(min, cnt);
		}

	}

	
}
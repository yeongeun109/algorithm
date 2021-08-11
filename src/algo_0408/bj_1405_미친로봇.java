package algo_0408;

import java.util.Scanner;

public class bj_1405_미친로봇 {

	static int N;
	static boolean map[][] = new boolean[2 * 15][2 * 15];
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static double[] percent = new double[4];
	static double res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 0; i < 4; i++) {
			percent[i] = sc.nextInt() * 0.01;
		}

		dfs(N, N, 1, N);
		System.out.println(res);
	}

	private static void dfs(int x, int y, double p, int cnt) {
		if(map[x][y])
			return;
		
		if(cnt == 0) {
			res += p;
			return;
		}
		
		map[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int tempx = x + dx[i];
			int tempy = y + dy[i];
			
			if(!map[tempx][tempy]) {
				dfs(tempx, tempy, p * percent[i], --cnt);
				cnt++;
				map[tempx][tempy] = false;
			}
		}
	}

}

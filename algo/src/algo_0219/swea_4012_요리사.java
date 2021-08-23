package algo_0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4012_요리사 {

	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static int N, sum;
	static int[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			selected = new int[N/2];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			comb(0, 0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(min);
			System.out.println(sb);
		}
	}

	private static void comb(int cnt, int start) {
		if(cnt == N/2) {
			int[] food1 = new int[N/2];
			int[] food2 = new int[N/2];
			boolean[] all = new boolean[N];
			for(int i = 0; i < N / 2; i++) {
				all[selected[i]] = true;
				food1[i] = selected[i];
			}
			int j = 0;
			for(int i = 0; i < N; i++) {
				if(all[i] == false) {
					food2[j] = i;
					j++;
				}
			}
			calcFood(food1, food2);
			return;
		}
		
		for (int i = start; i < N; i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	private static void perm(int cnt, boolean[] newSelected, int[] index, int[] food) {
		if(cnt == 2) {
			sum += arr[food[index[0]]][food[index[1]]];
			return;
		}
		
		for (int i = 0; i < N / 2; i++) {
			if(newSelected[i] == false) {
				newSelected[i] = true;
				index[cnt] = i;
				perm(cnt + 1, newSelected, index, food);
				newSelected[i] = false;
			}
		}
	}

	private static void calcFood(int[] food1, int[] food2) {
		boolean[] newSelected = new boolean[N / 2];
		int[] index = new int[2];
		sum = 0;
		perm(0, newSelected, index, food1);
		int sum1 = sum;
		sum = 0;
		perm(0, newSelected, index, food2);
		int sum2 = sum;
		
		min = Math.min(min, Math.abs(sum1-sum2));
	}

}

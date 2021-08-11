package algo_0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_14889_스타트와링크 {

	static int N, min = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		selected = new int[N/2];
		selected[0] = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(1, 1);
		System.out.println(min);
	}

	private static void comb(int cnt, int start) {
		if(cnt == N/2) {
			makeNum(selected);
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void makeNum(int[] selected) {
		boolean[] nArr = new boolean[N];
		ArrayList<Integer> teamA = new ArrayList<Integer>();
		ArrayList<Integer> teamB = new ArrayList<Integer>();
		
		for(int i = 0; i < N/2; i++) {
			nArr[selected[i]] = true;
		}
		
		for(int i = 0; i < N; i++) {
			if(nArr[i] == true)
				teamA.add(i);
			else
				teamB.add(i);
		}
		
		/*System.out.println(teamA);
		System.out.println(teamB);
		System.out.println("-------------------");*/
		int sumA = 0, sumB = 0, diff = 0;
		
		for(int i = 0; i < N/2 - 1; i++) {
			for(int j = i+1; j < N/2; j++) {
				int a = teamA.get(i);
				int b = teamA.get(j);
				sumA += arr[a][b] + arr[b][a];
			}
		}
		
		for(int i = 0; i < N/2 - 1; i++) {
			for(int j = i+1; j < N/2; j++) {
				int a = teamB.get(i);
				int b = teamB.get(j);
				sumB += arr[a][b] + arr[b][a];
			}
		}
		
		diff = Math.abs(sumA - sumB);
		min = Math.min(min, diff);
		/*System.out.println(sumA);
		System.out.println(sumB);
		System.out.println("-------------------");*/
	}

}

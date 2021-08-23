package algo_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2961_도영이가만든맛있는음식 {
	
	static int[][] food;
	static boolean[] selected;
	static int N;
	static long result = 10000000000L;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		food = new int[N][2];
		selected = new boolean[N];
		
		for(int n = 0; n < N; n++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			food[n][0] = Integer.parseInt(st.nextToken());
			food[n][1] = Integer.parseInt(st.nextToken());
		}
		powerSet(0);
		System.out.println(result);
	}
	
	static private void powerSet(int cnt) {
		if(cnt == N) {
			diff(selected);
			return;
		}
		
		selected[cnt] = true;
		powerSet(cnt+1);
		selected[cnt] = false;
		powerSet(cnt+1);
	}
	
	static private void diff(boolean[] selected) {
		long sour = 1;
		long bit = 0;
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			if(selected[i] == true) {
				cnt++;
				sour *= food[i][0];
				bit += food[i][1];
			}
		}
		
		if(cnt == 0)
			return;
		
		long diff = 0;
		if(sour > bit) {
			diff = sour - bit;
		}else {
			diff = bit - sour;
		}
		
		result = Math.min(result, diff);
	}
}

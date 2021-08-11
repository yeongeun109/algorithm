package algo_0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2491_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int up = 0, down = 0, upMax = 0, downMax = 0, upCnt = 0, downCnt = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] >= up) {
				up = arr[i];
				upCnt++;
				upMax = Math.max(upMax, upCnt);
			}else {
				up = arr[i];
				upCnt = 1;
			}
			
			if(arr[i] <= down) {
				down = arr[i];
				downCnt++;
				downMax = Math.max(downMax, downCnt);
			}else {
				down = arr[i];
				downCnt = 1;
			}
		}
		
		System.out.println(Math.max(upMax, downMax));
	}

}

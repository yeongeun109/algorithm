package algo_0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2110_공유기설치 {

	static int N, C, res;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		int left = 0;
		int right = arr[N - 1] - arr[0];
		int mid = (left + right) / 2;
		
		while(left <= right) {
			if(calc(mid) < C) {
				right = mid;
				mid = (left + right) / 2;
			}else if(calc(mid) == C){
				
			//}else {
				left = mid;
				int tmp = (left + right) / 2;
				if(tmp == mid)
					break;
				mid = tmp;
			}
		}
		System.out.println(res);
	}

	private static int calc(int mid) {
		int currNode = arr[0];
		int cnt = 1, min = Integer.MAX_VALUE;
		
		for(int i = 1; i < N; i++) {
			if(arr[i] - currNode >= mid) {
				cnt++;
				min = Math.min(min, arr[i] - currNode);
				currNode = arr[i];
			}
			if(cnt == C)
				break;
		}
		
		if(cnt == C) {
			res = Math.max(res, min);
		}
		return cnt;
	}

}

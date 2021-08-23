package algo_0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1477_휴게소세우기 {

	static int N, M, res;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = L;
		int mid = (left + right) / 2;
		while(left <= right) {
			if(calc(mid) < M) {
				right = mid;
				mid = (left + right) / 2;
			}else {
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
		int cnt = 0, min = Integer.MAX_VALUE;
		
		for(int i = 1; i < N; i++) {
			if(arr[i] - currNode >= mid) {
				cnt++;
				min = Math.min(min, arr[i] - currNode);
				currNode = arr[i];
			}
			if(cnt == M)
				break;
		}
		
		if(cnt == M) {
			res = Math.max(res, min);
		}
		return cnt;
	}

}

/*3 1 1000
200 701 800*/


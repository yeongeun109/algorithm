package algo_0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2512_예산 {

	static int N, res, yesan;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		int requested = 0, max = 0;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			requested += arr[i];
			max = Math.max(max, arr[i]);
		}
		
		yesan = Integer.parseInt(in.readLine());
		if(requested <= yesan) {
			res = max;
		}else {
			int num = yesan;
			int left = 0, right = num, mid = num / 2;
			while(left < right) {
				if(calc(mid)) {
					left = mid;
					int tmp = (left + right) / 2;
					if(tmp == mid)
						break;
					mid = tmp;
				}else {
					right = mid;
					mid = (left + right) / 2;
				}
			}
		}
		
		System.out.println(res);
	}

	private static boolean calc(int mid) {
		int sum = 0, max = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] <= mid) {
				sum += arr[i];
				max = Math.max(max, arr[i]);
			}else {
				sum += mid;
				max = mid;
			}
		}	
		
		if(sum < yesan) {
			res = Math.max(res, max);
			return true;
		}if(sum == yesan) {
			res = Math.max(res, max);
			return false;
		}
		return false;
	}

}
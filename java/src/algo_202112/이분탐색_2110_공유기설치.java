package algo_202112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분탐색_2110_공유기설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(in.readLine());

		Arrays.sort(arr);
		int left = 1;
		int right = arr[N - 1] - arr[0];
		int mid = 0;
		int res = 0;

		while (left <= right) {
			mid = (right + left) / 2;
			int cnt = 1;
			int start = arr[0];
			for (int i = 1; i < N; i++) {
				int d = arr[i] - start;
				if (d >= mid) {
					cnt++;
					start = arr[i];
				}
			}
			if (cnt < C) {
				right = mid - 1;
			} else {
				res = mid;
				left = mid + 1;
			}
		}

		System.out.println(res);
	}

}

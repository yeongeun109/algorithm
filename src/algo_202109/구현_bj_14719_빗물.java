package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구현_bj_14719_빗물 {

	static int res = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int left = arr[0];
		int right = 0;

		for (int i = 1; i < M - 1; i++) {
			for (int j = 0; j < i; j++)
				left = Math.max(left, arr[j]);

			for (int j = i + 1; j < M; j++)
				right = Math.max(right, arr[j]);

			int height = Math.min(left, right);
			res += Math.max(0, height - arr[i]);
			right = 0;
			left = 0;
		}
		System.out.println(res);
	}
}

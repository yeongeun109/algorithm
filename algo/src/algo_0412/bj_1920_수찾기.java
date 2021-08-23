package algo_0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = N - 1;
			int mid = N / 2;
			boolean flag = false;
			
			while (left <= right) {
				mid = (left + right) / 2;
				if (num > arr[mid]) {
					left = mid + 1;
				} else if (num < arr[mid]) {
					right = mid - 1;
				} else {
					sb.append(1).append("\n");
					flag = true;
					break;
				}
			}
			
			if(!flag)
				sb.append(0).append("\n");
		}
		System.out.println(sb);
	}

}

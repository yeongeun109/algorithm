package algo_202108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구현_bj_18111_마인크래프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int min = 500, max = 0, time = Integer.MAX_VALUE, h = 0;
		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}
		}

		for (int i = min; i <= max; i++) {
			int cnt = 0;
			int tmpB = B;

			// 블록제거
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[j][k] > i) {
						int diff = arr[j][k] - i;
						cnt += 2 * diff;
						tmpB += diff;
					}
				}
			}

			boolean flag = true;
			// 블록채우기
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[j][k] < i) {
						int diff = i - arr[j][k];
						if (tmpB >= diff) {
							cnt += diff;
							tmpB -= diff;
						} else {
							flag = false;
							break;
						}
					}
				}

				if (!flag)
					break;
			}

			if (!flag)
				continue;

			if (time > cnt) {
				time = cnt;
				h = i;
			} else if (time == cnt) {
				h = Math.max(h, i);
			}
		}
		System.out.println(time + " " + h);
	}

}

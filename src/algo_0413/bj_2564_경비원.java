package algo_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int garo = Integer.parseInt(st.nextToken());
		int sero = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(in.readLine());
		int dongx = 0, dongy = 0, dongz = 0;
		int[][] store = new int[n][3];

		for (int i = 0; i < n + 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (i != n) {
				if (x == 1) {
					store[i][0] = 0;
					store[i][1] = y;
					store[i][2] = x;
				} else if (x == 2) {
					store[i][0] = sero;
					store[i][1] = y;
					store[i][2] = x;
				} else if (x == 3) {
					store[i][1] = 0;
					store[i][0] = y;
					store[i][2] = x;
				} else {
					store[i][1] = garo;
					store[i][0] = y;
					store[i][2] = x;
				}
			} else {
				if (x == 1) {
					dongx = 0;
					dongy = y;
					dongz = x;
				} else if (x == 2) {
					dongx = sero;
					dongy = y;
					dongz = x;
				} else if (x == 3) {
					dongy = 0;
					dongx = y;
					dongz = x;
				} else {
					dongy = garo;
					dongx = y;
					dongz = x;
				}
			}
		}

		int res = 0;
		if (dongz == 1) {
			for (int i = 0; i < n; i++) {
				int diff = 0;
				if (store[i][2] == 1) {
					diff = Math.abs(store[i][1] - dongy );
				} else if (store[i][2] == 2) {
					int left = sero + dongy + store[i][1];
					int right = sero + (garo - dongy) + (garo - store[i][1]);
					diff = Math.min(left, right);
				} else if (store[i][2] == 3) {
					diff = dongy + store[i][0];
				} else {
					diff = garo - dongy + store[i][0];
				}
				res += diff;
			}
		} else if (dongz == 2) {
			for (int i = 0; i < n; i++) {
				int diff = 0;
				if (store[i][2] == 1) {
					int left = sero + dongy + store[i][1];
					int right = sero + (garo - dongy) + (garo - store[i][1]);
					diff = Math.min(left, right);
				} else if (store[i][2] == 2) {
					diff = Math.abs(store[i][1] - dongy);
				} else if (store[i][2] == 3) {
					diff = dongy + sero - store[i][0];
				} else {
					diff = garo - dongy + sero - store[i][0];
				}
				res += diff;
			}
		} else if (dongz == 3) {
			for (int i = 0; i < n; i++) {
				int diff = 0;
				if (store[i][2] == 1) {
					diff = dongx + store[i][1];
				} else if (store[i][2] == 2) {
					diff = sero - dongx + store[i][1];
				} else if (store[i][2] == 3) {
					diff = Math.abs(dongx - store[i][0]);
				} else {
					int up = dongx + garo + store[i][0];
					int down = sero - dongx + garo + sero - store[i][0];
					diff = Math.min(up, down);
				}
				res += diff;
			}
		} else {
			for (int i = 0; i < n; i++) {
				int diff = 0;
				if (store[i][2] == 1) {
					diff = dongx + garo - store[i][1];
				} else if (store[i][2] == 2) {
					diff = sero - dongx + garo - store[i][1];
				} else if (store[i][2] == 3) {
					int up = dongx + garo + store[i][0];
					int down = sero - dongx + garo + sero - store[i][0];
					diff = Math.min(up, down);
				} else {
					diff = Math.abs(dongx - store[i][0]);
				}
				res += diff;
			}
		}
		
		System.out.println(res);
	}

}
/*
10 5
4
1 8
3 2
4 4
2 3
1 4

10 5
4
1 4
2 8
3 2
4 4
2 3

10 5
4
1 4
2 3
3 4
4 4
3 2
 */
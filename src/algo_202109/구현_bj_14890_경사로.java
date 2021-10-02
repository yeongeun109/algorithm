package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 구현_bj_14890_경사로 {

	static int N, L;
	static int[][] arr;
	static boolean[][] way;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		way = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayList<int[]> list = new ArrayList<>();
		int res = 0;

		for (int i = 0; i < N; i++) {
			int h = arr[i][0];
			int cnt = 1;
			boolean flag = true;
			for (int j = 1; j < N; j++) {
				if (arr[i][j] > h && Math.abs(arr[i][j] - h) == 1) {
					if (cnt >= L) {
//						System.out.println(i + " " + j);
						if (!putway(i, j - 1, 0)) {
							flag = false;
							break;
						}
						cnt = 1;
						h = arr[i][j];
						continue;
					} else {
						flag = false;
						break;
					}
				} else if (arr[i][j] != h && Math.abs(arr[i][j] - h) != 1) {
					flag = false;
					break;
				} else if (arr[i][j] != h && Math.abs(arr[i][j] - h) == 1) {
					cnt = 1;
					h = arr[i][j];
				} else if (arr[i][j] == h)
					cnt++;
			}

			if (!flag)
				continue;

			h = arr[i][N - 1];
			cnt = 1;
			for (int j = N - 2; j >= 0; j--) {
				if (arr[i][j] > h && Math.abs(arr[i][j] - h) == 1) {
					if (cnt >= L) {
						if (!putway(i, j + 1, 1)) {
							flag = false;
							break;
						}
						cnt = 1;
						h = arr[i][j];
						continue;
					} else {
						flag = false;
						break;
					}
				} else if (arr[i][j] != h && Math.abs(arr[i][j] - h) != 1) {
					flag = false;
					break;
				} else if (arr[i][j] != h && h - arr[i][j] == 1) {
					cnt = 0;
					h = arr[i][j];
				} else if (arr[i][j] == h)
					cnt++;
			}

			if (flag) {
				res++;
				list.add(new int[] { 0, i });
			}
		}

		// 세로
		way = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			int h = arr[0][i];
			int cnt = 1;
			boolean flag = true;
			for (int j = 1; j < N; j++) {
				if (arr[j][i] > h && Math.abs(arr[j][i] - h) == 1) {
					if (cnt >= L) {
						if (!putwayDown(i, j - 1, 0)) {
							flag = false;
							break;
						}
						cnt = 1;
						h = arr[j][i];
						continue;
					} else {
						flag = false;
						break;
					}
				} else if (arr[j][i] != h && Math.abs(arr[j][i] - h) != 1) {
					flag = false;
					break;
				} else if (arr[j][i] != h && Math.abs(arr[j][i] - h) == 1) {
					cnt = 1;
					h = arr[j][i];
				} else if (arr[j][i] == h)
					cnt++;
			}

			if (!flag)
				continue;

			h = arr[N - 1][i];
			cnt = 1;
			for (int j = N - 2; j >= 0; j--) {
				if (arr[j][i] > h && Math.abs(arr[j][i] - h) == 1) {
					if (cnt >= L) {
						if (!putwayDown(i, j + 1, 1)) {
							flag = false;
							break;
						}
						cnt = 1;
						h = arr[j][i];
						continue;
					} else {
						flag = false;
						break;
					}
				} else if (arr[j][i] != h && Math.abs(arr[j][i] - h) != 1) {
					flag = false;
					break;
				} else if (arr[j][i] != h && h - arr[j][i] == 1) {
					cnt = 1;
					h = arr[j][i];
				} else if (arr[j][i] == h)
					cnt++;
			}

			if (flag) {
				res++;
				list.add(new int[] { 1, i });
			}
		}

		System.out.println(res);
	}

	private static boolean putway(int i, int j, int d) {
		boolean flag = true;
		if (d == 0) {
			for (int k = j; k >= j - L + 1; k--) {
				if (way[i][k]) {
					flag = false;
					break;
				}
				way[i][k] = true;
			}
		} else {
			for (int k = j; k <= j + L - 1; k++) {
				if (way[i][k]) {
					flag = false;
					break;
				}
				way[i][k] = true;
			}
		}

		return flag;
	}

	private static boolean putwayDown(int i, int j, int d) {
		boolean flag = true;
		if (d == 0) {
			for (int k = j; k >= j - L + 1; k--) {
				if (way[k][i]) {
					flag = false;
					break;
				}
				way[k][i] = true;
			}
		} else {
			for (int k = j; k <= j + L - 1; k++) {
				if (way[k][i]) {
					flag = false;
					break;
				}
				way[k][i] = true;
			}
		}

		return flag;
	}

}

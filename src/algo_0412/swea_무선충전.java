package algo_0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_무선충전 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] dx = { 0, -1, 0, 1, 0 };
		int[] dy = { 0, 0, 1, 0, -1 };
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // 이동시간
			int A = Integer.parseInt(st.nextToken()); // bc 개수
			int[] a = new int[M];
			int[] b = new int[M];

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++)
				a[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++)
				b[i] = Integer.parseInt(st.nextToken());

			List<int[]> list = new ArrayList<int[]>();
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()); // 충전범위
				int p = Integer.parseInt(st.nextToken()); // 처리량
				list.add(new int[] { x, y, c, p });
			}

			int ax = 0, ay = 0, bx = 9, by = 9;
			int aSum = 0, bSum = 0;
			int sum = 0;
			for (int i = 0; i <= M; i++) {
				boolean[][] flag = new boolean[2][A];

				for (int j = 0; j < A; j++) {
					int diffA = Math.abs(ax - list.get(j)[0]) + Math.abs(ay - list.get(j)[1]);
					int diffB = Math.abs(bx - list.get(j)[0]) + Math.abs(by - list.get(j)[1]);
					if (diffA <= list.get(j)[2])
						flag[0][j] = true;
					if (diffB <= list.get(j)[2])
						flag[1][j] = true;
				}

				int tempSum = 0;
				for (int k = 0; k < A; k++) {
					for (int l = 0; l < A; l++) {
						if (k == l && flag[0][k] && flag[1][l]) {
							tempSum = Math.max(list.get(k)[3], tempSum);
						} else {
							if (flag[0][k] && flag[1][l])
								tempSum = Math.max(list.get(l)[3] + list.get(k)[3], tempSum);
							else if (flag[0][k])
								tempSum = Math.max(list.get(k)[3], tempSum);
							else if (flag[1][l])
								tempSum = Math.max(list.get(l)[3], tempSum);
						}
					}
				}
				sum += tempSum;

				if (i < M) {
					ax += dx[a[i]];
					bx += dx[b[i]];
					ay += dy[a[i]];
					by += dy[b[i]];
				}

			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

}

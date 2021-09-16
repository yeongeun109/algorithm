package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구현_bj_17281_야구공 {

	static boolean[] selected = new boolean[9];
	static int[] turn = new int[9];
	static int[][] score;
	static int N, max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		score = new int[N][9];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(0);
		System.out.println(max);
	}

	private static int[] calc(int[] tturn, int[] tscore) {
		int score = 0, out = 0, lastturn = -1;
		int[] ground = new int[3];
		int i = 0;
		while (out < 3) {
			if (tscore[tturn[i]] == 0) {
				out++;
				if(out == 3)
					lastturn = i;
			} else if (tscore[tturn[i]] == 1) {
				if (ground[2] != 0)
					score++;
				ground[2] = ground[1];
				ground[1] = ground[0];
				ground[0] = 1;
			} else if (tscore[tturn[i]] == 2) {
				if (ground[1] == 1 && ground[2] == 1)
					score += 2;
				else if (ground[1] == 1 || ground[2] == 1)
					score += 1;
				ground[2] = ground[0];
				ground[0] = 0;
				ground[1] = 1;
			} else if (tscore[tturn[i]] == 3) {
				for (int j = 0; j < 3; j++) {
					if (ground[j] == 1) {
						score++;
						ground[j] = 0;
					}
				}
				ground[2] = 1;
			} else if (tscore[tturn[i]] == 4) {
				for (int j = 0; j < 3; j++) {
					if (ground[j] == 1)
						score++;
					ground[j] = 0;
				}
				score++;
			}
			i++;
			if (i == 9)
				i -= 9;
		}

		return new int[] { score, lastturn };
	}

	private static void perm(int cnt) {
		if (cnt == 9) {
			int tscore = 0;
			int[] ttmp = new int[9];
			for (int i = 0; i < 9; i++)
				ttmp[i] = turn[i];
			for (int i = 0; i < N; i++) {
				int[] tmp = calc(ttmp, score[i]);
				tscore += tmp[0];

				if (tmp[1] != -1) {
					if (i < N - 1) {
						int[] tmpturn = new int[9];
						int k = tmp[1] + 1;
						for (int j = 0; j < 8 - tmp[1]; j++) {
							tmpturn[j] = ttmp[k++];
						}
						k = 0;
						for (int j = 8 - tmp[1]; j < 9; j++) {
							tmpturn[j] = ttmp[k++];
						}
						for (int j = 0; j < 9; j++)
							ttmp[j] = tmpturn[j];
					}
				}
			}
			max = Math.max(max, tscore);
			return;
		}

		if (cnt == 3) {
			perm(cnt + 1);
		} else {
			for (int i = 1; i < 9; i++) {
				if (!selected[i]) {
					selected[i] = true;
					turn[cnt] = i;
					perm(cnt + 1);
					selected[i] = false;
				}
			}
		}

	}

}

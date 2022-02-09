package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 구현_20056_마법사상어와파이어볼 {
	static int N;

	public static class Ball {
		int r;
		int c;
		int m; // 질량
		int s; // 속력
		int d; // 방향

		public Ball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return r + " " + c + " " + m + " " + s + " " + d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 명령 수

		ArrayList<Integer>[] list = new ArrayList[N * N + 1];

		for (int i = 1; i <= N * N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		Map<Integer, Ball> map = new HashMap<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int num = i + 1;
			Ball ball = new Ball(r, c, m, s, d);
			map.put(num, ball);
			list[N * (r - 1) + c].add(num);
		}

		int cnt = M;
		for (int i = 0; i < K; i++) {
			List<Integer> overTwo = new ArrayList<Integer>();
			for (Integer key : map.keySet()) {
				Ball val = map.get(key);
				Ball movedBall = move(val);
				list[N * (val.r - 1) + val.c].remove(key);
				list[N * (movedBall.r - 1) + movedBall.c].add(key);
				map.get(key).r = movedBall.r;
				map.get(key).c = movedBall.c;
			}

			for (int j = 1; j <= N * N; j++) {
				if (list[j].size() >= 2) {
					overTwo.add(j);
				}
			}

			for (int j = 0; j < overTwo.size(); j++) {
				int idx = overTwo.get(j);
				int nr = 0, nc = 0, nm = 0, ns = 0, ballnum = list[idx].size(), even = 0, odd = 0;
				boolean allSame = false;
				for (int k = 0; k < list[idx].size(); k++) {
					nm += map.get(list[idx].get(k)).m;
					ns += map.get(list[idx].get(k)).s;
					nr = map.get(list[idx].get(k)).r;
					nc = map.get(list[idx].get(k)).c;

					if (map.get(list[idx].get(k)).d % 2 == 0)
						even++;
					else
						odd++;

					map.remove(list[idx].get(k));
				}

				list[idx].clear();

				if (even == 0 || odd == 0)
					allSame = true;

				if (allSame) {
					int nd = 0;
					for (int k = 0; k < 4; k++) {
						Ball nball = new Ball(nr, nc, nm / 5, ns / ballnum, nd);
						if (nball.m > 0) {
							map.put(++cnt, nball);
							list[idx].add(cnt);
						}
						nd += 2;
					}
				} else {
					int nd = 1;
					for (int k = 0; k < 4; k++) {
						Ball nball = new Ball(nr, nc, nm / 5, ns / ballnum, nd);
						if (nball.m > 0) {
							map.put(++cnt, nball);
							list[idx].add(cnt);
						}
						nd += 2;
					}
				}

			}
		}

		int res = 0;
		for (Integer key : map.keySet()) {
			res += map.get(key).m;
		}

		System.out.println(res);
	}

	private static Ball move(Ball val) {
		int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

		int ts = val.s % N;
		int tr = val.r + dx[val.d] * ts;
		int tc = val.c + dy[val.d] * ts;

		if (tr <= 0)
			tr = N + tr;
		else if (tr > N)
			tr -= N;

		if (tc <= 0)
			tc = N + tc;
		else if (tc > N)
			tc -= N;

		Ball ball = new Ball(tr, tc, val.m, val.s, val.d);
		return ball;
	}

}

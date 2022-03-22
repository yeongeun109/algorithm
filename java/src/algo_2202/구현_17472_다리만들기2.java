package algo_2202;

import java.io.*;
import java.util.*;

public class 구현_17472_다리만들기2 {
	static int N, M, areaIdx = 0;
	static int[][] map;
	static List<Integer>[] areaXList = new List[7];
	static List<Integer>[] areaYList = new List[7];
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 1; i < 7; i++) {
			areaXList[i] = new ArrayList<>();
			areaYList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeArea();

		int[][] dist = new int[areaIdx + 1][areaIdx + 1];
		parent = new int[areaIdx + 1];

		for (int i = 1; i <= areaIdx; i++) {
			parent[i] = i;
			for (int j = i + 1; j <= areaIdx; j++) {
				dist[i][j] = Integer.MAX_VALUE;

				for (int a = 0; a < areaXList[i].size(); a++) {
					for (int b = 0; b < areaXList[j].size(); b++) {
						int tmpA = areaXList[i].get(a), tmpB = areaXList[j].get(b);
						if (tmpA == tmpB) { // x좌표가 겹치면
							int tmpYA = areaYList[i].get(a), tmpYB = areaYList[j].get(b);
							if (check(tmpA, tmpB, tmpYA, tmpYB, 0)) {
								int tmp = Math.abs(tmpYA - tmpYB) - 1;
								if (tmp >= 2)
									dist[i][j] = Math.min(dist[i][j], tmp);
							}
						}
					}
				}

				for (int a = 0; a < areaYList[i].size(); a++) {
					for (int b = 0; b < areaYList[j].size(); b++) {
						int tmpA = areaYList[i].get(a), tmpB = areaYList[j].get(b);
						if (tmpA == tmpB) { // x좌표가 겹치면
							int tmpYA = areaXList[i].get(a), tmpYB = areaXList[j].get(b);
							if (check(tmpYA, tmpYB, tmpA, tmpB, 1)) {
								int tmp = Math.abs(tmpYA - tmpYB) - 1;
								if (tmp >= 2)
									dist[i][j] = Math.min(dist[i][j], tmp);
							}
						}
					}
				}
			}
		}

		PriorityQueue<int[]> bridge = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int i = 1; i <= areaIdx; i++) {
			for (int j = i + 1; j <= areaIdx; j++) {
				if (dist[i][j] != Integer.MAX_VALUE) {
					bridge.offer(new int[] { i, j, dist[i][j] });
				}
			}
		}

		int res = 0, cnt = 0;
		while (!bridge.isEmpty()) {
			int[] tmp = bridge.poll();
			if (!union(tmp[0], tmp[1])) {
				res += tmp[2];
				if(++cnt == areaIdx)
					break;
			}
		}

		if(res == 0 || cnt != areaIdx - 1)
			System.out.println(-1);
		else
			System.out.println(res);
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return true;

		parent[rootB] = rootA;
		return false;
	}

	private static int find(int a) {
		if (parent[a] == a)
			return a;

		return parent[a] = find(parent[a]);
	}

	private static boolean check(int tmpA, int tmpB, int tmpYA, int tmpYB, int type) {
		if (type == 0) { // 가로 길이 비교
			if (tmpYA >= tmpYB) {
				for (int i = tmpYB + 1; i < tmpYA; i++) {
					if (map[tmpB][i] != 0)
						return false;
				}
			} else {
				for (int i = tmpYA + 1; i < tmpYB; i++) {
					if (map[tmpA][i] != 0)
						return false;
				}
			}
		} else {
			if (tmpA >= tmpB) {
				for (int i = tmpB + 1; i < tmpA; i++) {
					if (map[i][tmpYB] != 0)
						return false;
				}
			} else {
				for (int i = tmpA + 1; i < tmpB; i++) {
					if (map[i][tmpYA] != 0)
						return false;
				}
			}
		}
		return true;
	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	private static void makeArea() {

		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					areaIdx++;
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] { i, j });
					visited[i][j] = true;

					while (!q.isEmpty()) {
						int[] tmp = q.poll();
						int cx = tmp[0];
						int cy = tmp[1];

						for (int l = 0; l < 4; l++) {
							int ttx = cx + dx[l];
							int tty = cy + dy[l];

							if (ttx < 0 || ttx >= N || tty < 0 || tty >= M)
								continue;

							if (map[ttx][tty] == 0) {
								areaXList[areaIdx].add(cx);
								areaYList[areaIdx].add(cy);
								break;
							}
						}

						for (int k = 0; k < 4; k++) {
							int tx = cx + dx[k];
							int ty = cy + dy[k];

							if (tx < 0 || tx >= N || ty < 0 || ty >= M || visited[tx][ty])
								continue;

							if (map[tx][ty] == 1) {
								q.offer(new int[] { tx, ty });
								visited[tx][ty] = true;
							}
						}
					}
				}
			}
		}
	}
}
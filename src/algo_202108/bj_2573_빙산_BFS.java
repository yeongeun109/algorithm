package algo_202108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2573_빙산_BFS {

	static int N, M;
	static Queue<int[]> q = new LinkedList<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int mCnt = 0; // 빙산수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0) {
					mCnt++;
				}
			}
		}
		int year = 0;
		int ans = 0;

		while (mCnt != 0) {
			year++;

			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0 && !visited[i][j]) {
						q.offer(new int[] { i, j });
						visited[i][j] = true;

						while (!q.isEmpty()) {
							int[] tmp = q.poll();
							int currX = tmp[0];
							int currY = tmp[1];

							for (int k = 0; k < 4; k++) {
								int tmpX = currX + dx[k];
								int tmpY = currY + dy[k];

								if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M || visited[tmpX][tmpY])
									continue;

								if (arr[tmpX][tmpY] == 0) {
									q.offer(new int[] { tmpX, tmpY });
									visited[tmpX][tmpY] = true;
								} else {
									arr[tmpX][tmpY]--;
									if (arr[tmpX][tmpY] == 0) {
										mCnt--;
										visited[tmpX][tmpY] = true;
									}
								}
							}
						}

					}
				}
			}

			if (check(arr) != 1 && check(arr) != 0) {
				ans = year;
				break;
			}
		}

		System.out.println(ans);
	}

	private static int check(int[][] arr) {
		int cnt = 0;
		boolean[][] newvisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0 && !newvisited[i][j]) {
					cnt++;
					q.offer(new int[] { i, j });
					newvisited[i][j] = true;

					while (!q.isEmpty()) {
						int[] tmp = q.poll();
						int currX = tmp[0];
						int currY = tmp[1];

						for (int k = 0; k < 4; k++) {
							int tmpX = currX + dx[k];
							int tmpY = currY + dy[k];

							if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M || newvisited[tmpX][tmpY])
								continue;

							if (arr[tmpX][tmpY] != 0) {
								q.offer(new int[] { tmpX, tmpY });
								newvisited[tmpX][tmpY] = true;

							}
						}
					}
				}
			}
		}

		return cnt;
	}

}

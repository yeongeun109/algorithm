package algo_0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_14497_주난의난 {

	static int N, M, x1, y1, x2, y2, res = 0;
	static char[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M];

		st = new StringTokenizer(in.readLine(), " ");
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String str = in.readLine();

			arr[i] = str.toCharArray();

		}

		bfs();
		System.out.println(res);

	}

	private static void bfs() {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		pq.offer(new int[] { x1 - 1, y1 - 1, 0 });
		visited[x1 - 1][y1 - 1] = true;

		while (!pq.isEmpty()) {
			int[] tempArr = pq.poll();
			int currX = tempArr[0];
			int currY = tempArr[1];
			int jump = tempArr[2];

			for (int i = 0; i < 4; i++) {
				int tempX = currX + dx[i];
				int tempY = currY + dy[i];

				if (tempX == N || tempX < 0 || tempY == M || tempY < 0 || visited[tempX][tempY])
					continue;

				if (arr[tempX][tempY] == '1') {
					pq.offer(new int[] { tempX, tempY, jump+1 });
					visited[tempX][tempY] = true;
				} else if (arr[tempX][tempY] == '0') {
					pq.offer(new int[] { tempX, tempY, jump });
					visited[tempX][tempY] = true;
				} else {
					res = jump + 1;
					return;
				}
			}
		}
	}

}

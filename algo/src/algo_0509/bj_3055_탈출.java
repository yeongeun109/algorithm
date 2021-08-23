package algo_0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_3055_탈출 {

	static int N, M, res = 0;
	static char[][] forest;
	static List<int[]> water = new ArrayList<int[]>();
	static int[] D = new int[2], S = new int[2], X = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		forest = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			forest[i] = str.toCharArray();

			for (int j = 0; j < M; j++) {
				if (forest[i][j] == 'D') {
					D[0] = i;
					D[1] = j;
				} else if (forest[i][j] == 'S') {
					S[0] = i;
					S[1] = j;
				} else if (forest[i][j] == '*') {
					water.add(new int[] { i, j });
				} else if (forest[i][j] == 'X') {
					X[0] = i;
					X[1] = j;
				}
			}
		}

		bfs();
		if(res != 0)
			System.out.println(res);
		else
			System.out.println("KAKTUS");
	}

	private static void bfs() {
		boolean[][] wvisited = new boolean[N][M];
		boolean[][] gvisited = new boolean[N][M];
		gvisited[S[0]][S[1]] = true;
		int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		Queue<int[]> w = new LinkedList<int[]>();

		pq.offer(new int[] { S[0], S[1], 0 });
		for (int i = 0; i < water.size(); i++) {
			w.offer(new int[] { water.get(i)[0], water.get(i)[1], 0 });
			wvisited[water.get(i)[0]][water.get(i)[1]] = true;
		}

		while (!pq.isEmpty()) {
			int size = w.size();
			for (int i = 0; i < size; i++) {
				int[] wtmp = w.poll();
				for (int j = 0; j < 4; j++) {
					int tmpWX = wtmp[0] + dx[j];
					int tmpWY = wtmp[1] + dy[j];

					if (tmpWX < 0 || tmpWX >= N || tmpWY < 0 || tmpWY >= M || forest[tmpWX][tmpWY] == 'X'
							|| forest[tmpWX][tmpWY] == 'D' || wvisited[tmpWX][tmpWY])
						continue;

					forest[tmpWX][tmpWY] = (char) (wtmp[2] + 1);
					w.offer(new int[] { tmpWX, tmpWY, wtmp[2] + 1 });
					wvisited[tmpWX][tmpWY] = true;
				}
			}

			size = pq.size();
			for (int j = 0; j < size; j++) {
				int[] tmp = pq.poll();
				int currX = tmp[0];
				int currY = tmp[1];
				int currT = tmp[2];

				if (currX == D[0] && currY == D[1]) {
					res = tmp[2];
					break;
				}

				for (int i = 0; i < 4; i++) {
					int tmpX = currX + dx[i];
					int tmpY = currY + dy[i];

					if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M 
							|| forest[tmpX][tmpY] == 'X' || gvisited[tmpX][tmpY])
						continue;

					if (forest[tmpX][tmpY] == '.' || forest[tmpX][tmpY] == 'D') {
						pq.offer(new int[] { tmpX, tmpY, (char) (currT + 1) });
						gvisited[tmpX][tmpY] = true;
					} else{
						int s = (int) forest[tmpX][tmpY] - '0';
						if (s > currT) {
							pq.offer(new int[] { tmpX, tmpY, (char) (currT + 1) });
							gvisited[tmpX][tmpY] = true;
						}
					}

				}
			}
		}
	}

}

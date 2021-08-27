package algo_202108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_bj_7569_토마토 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[H][N][M];
		int notYet = 0;
		boolean flag = false;
		int res = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						q.offer(new int[] { i, j, k });
						visited[i][j][k] = true;
					} else if (arr[i][j][k] == 0) {
						flag = true;
						notYet++;
					}
				}
			}
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		if (flag) {
			int day = 0;

			while (!q.isEmpty()) {
				day++;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] tmp = q.poll();
					int currH = tmp[0];
					int currX = tmp[1];
					int currY = tmp[2];

					for (int j = 0; j < 4; j++) {
						int tmpX = currX + dx[j];
						int tmpY = currY + dy[j];

						if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M || visited[currH][tmpX][tmpY])
							continue;

						if (arr[currH][tmpX][tmpY] == 0) {
							q.offer(new int[] { currH, tmpX, tmpY });
							visited[currH][tmpX][tmpY] = true;
							notYet--;
						}
					}

					if (currH + 1 < H && !visited[currH + 1][currX][currY]) {
						if (arr[currH + 1][currX][currY] == 0) {
							q.offer(new int[] { currH + 1, currX, currY });
							visited[currH + 1][currX][currY] = true;
							notYet--;
						}
					}
					if (currH - 1 >= 0 && !visited[currH - 1][currX][currY]) {
						if (arr[currH - 1][currX][currY] == 0) {
							q.offer(new int[] { currH - 1, currX, currY });
							visited[currH - 1][currX][currY] = true;
							notYet--;
						}
					}
				}
			}

			if (notYet != 0)
				res = -1;
			else
				res = day - 1;
		}

		System.out.println(res);
	}

}

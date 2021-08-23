package algo_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2636_치즈 {

	static int n, m, cheeze = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int hour = 0, cnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					arr[i][j] = temp;
					cheeze++;
				}
			}
		}

		while(cheeze != 0) {
			cnt = cheeze;
			bfs(arr);
			hour++;
		}
		
		System.out.println(hour);
		System.out.println(cnt);
	}

	private static void bfs(int[][] arr) {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			for (int k = 0; k < 4; k++) {
				int tempX = x + dx[k];
				int tempY = y + dy[k];
				if (tempX == n || tempX < 0 || tempY == m || tempY < 0 || visited[tempX][tempY])
					continue;

				if (arr[tempX][tempY] == 1) {
					arr[tempX][tempY] = 0;
					cheeze--;
				}else {
					q.offer(new int[] { tempX, tempY});
				}
				
				visited[tempX][tempY] = true;
			}
		}
	}

}

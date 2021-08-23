package algo_0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5656_벽돌깨기 {

	static int[][] arr;
	static int N, W, H, min = Integer.MAX_VALUE;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			selected = new int[N];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			makePerm(0);
			System.out.println("#" + t + " " + min);
		}
	}

	private static int findTop(int i, int[][] tmparr) {
		int top = 0;
		for (int j = 0; j < H; j++) {
			if (tmparr[j][i] != 0) {
				top = j;
				break;
			}
		}
		return top;
	}

	private static void makePerm(int cnt) {
		if (cnt == N) {
			int[][] temparr = new int[H][W];
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++)
					temparr[i][j] = arr[i][j];
			}
			
			int result = bfs(selected, temparr);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < W; i++) {
			selected[cnt] = i;
			makePerm(cnt + 1);
		}
	}

	private static int bfs(int[] selected, int[][] tmparr) {
		int cnt = 0;

		for(int i = 0; i < N; i++) {
			Queue<int[]> q = new LinkedList<int[]>();
			int y = selected[i];
			int x = findTop(y, tmparr);
			int num = tmparr[x][y];
			q.offer(new int[] {x, y, num});
			tmparr[x][y] = 0;

			while (!q.isEmpty()) {
				int tmp[] = q.poll();
				int currX = tmp[0];
				int currY = tmp[1];
				int num2 = tmp[2];

				for (int k = 0; k < 4; k++) {
					int tempX = currX;
					int tempY = currY;
					for (int l = 1; l < num2; l++) {
						tempX += dx[k];
						tempY += dy[k];

						if (tempX < 0 || tempX >= H || tempY < 0 || tempY >= W || tmparr[tempX][tempY] == 0)
							continue;

						if (tmparr[tempX][tempY] != 1) {
							q.offer(new int[] { tempX, tempY, tmparr[tempX][tempY] });
						}
						tmparr[tempX][tempY] = 0;
					}
				}
			}
			down(tmparr);
		}

		
		cnt = getRemain(tmparr);
		return cnt;
	}

	private static ArrayList<Integer> list = new ArrayList<Integer>();

	private static void down(int[][] newMap) {
		for (int c = 0; c < W; c++) {
			for (int r = H - 1; r >= 0; r--) {
				if (newMap[r][c] > 0) { // 벽돌이면
					list.add(newMap[r][c]);
					newMap[r][c] = 0;
				}
			} // 벽돌리스트에 넣기

			int r = H;
			for (int b : list) { // 리스트에 담긴 벽돌 차례대로 꺼내어 맨 아래행부터 채우기
				newMap[--r][c] = b;
			}
			list.clear();
		}
	}
	
	private static int getRemain(int[][] map) {
		int count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] > 0)
					++count;
			}
		}
		return count;
	}

}

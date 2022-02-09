package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구현_bj_21610_마법사상어와비바라기 {

	static int[][] arr;
	static int N;
	static ArrayList<int[]> cloud = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cloud.add(new int[]{ N - 1, 0 });
		cloud.add(new int[]{ N - 1, 1 });
		cloud.add(new int[]{ N - 2, 0 });
		cloud.add(new int[]{ N - 2, 1 });
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			move(d, s);
//			for (int j = 0; j < N; j++) {
//				System.out.println(Arrays.toString(arr[j]));
//			}
//			System.out.println("-----------------");
			
			
		}
		int res = 0;
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				res += arr[j][k];
			}
		}
		System.out.println(res);
	}

	private static void move(int d, int s) {
		int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
		int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

		ArrayList<int[]> movedCloud = new ArrayList<int[]>();
		for (int i = 0; i < cloud.size(); i++) {
			int x = cloud.get(i)[0] + (dx[d] * s) % N;
			int y = cloud.get(i)[1] + (dy[d] * s) % N;
			if (x < 0)
				x = N + x;
			else if (x >= N)
				x -= N;

			if (y < 0)
				y = N + y;
			else if (y >= N)
				y -= N;

			movedCloud.add(new int[] {x, y});
			arr[x][y]++;
		}
		cloud.clear();
		
		waterCopy(movedCloud);
		cloudAgain(movedCloud);
	}

	private static void cloudAgain(ArrayList<int[]> movedCloud) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean flag = false;
				for (int k = 0; k < movedCloud.size(); k++) {
					if (i == movedCloud.get(k)[0] && j == movedCloud.get(k)[1]) {
						flag = true;
						break;
					}
				}

				if (!flag && arr[i][j] >= 2) {
					arr[i][j] -= 2;
					cloud.add(new int[] {i, j});
				}
			}
		}
	}

	private static void waterCopy(ArrayList<int[]> movedCloud) {
		int[] dx = { -1, -1, 1, 1 };
		int[] dy = { -1, 1, 1, -1 };
		for (int i = 0; i < movedCloud.size(); i++) {
			for (int k = 0; k < 4; k++) {
				int x = movedCloud.get(i)[0] + dx[k];
				int y = movedCloud.get(i)[1] + dy[k];

				if (x < 0 || x >= N || y < 0 || y >= N)
					continue;

				if (arr[x][y] > 0) {
					arr[movedCloud.get(i)[0]][movedCloud.get(i)[1]]++;
				}
			}
		}
	}

}

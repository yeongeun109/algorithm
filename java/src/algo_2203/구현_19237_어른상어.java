package algo_2203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 구현_19237_어른상어 {

	static int[][] map;
	static int N, M, K;
	static List<Shark> sList = new ArrayList<>();
	static Map<Integer, int[]> smell = new HashMap<>();
	static List<int[]> smell2 = new ArrayList<>(); 
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static class Shark implements Comparable<Shark> {
		int x;
		int y;
		int d;
		int size;
		int[][] prior;

		public Shark(int x, int y, int d, int size, int[][] prior) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.size = size;
			this.prior = prior;
		}

		@Override
		public int compareTo(Shark s) {
			return this.size - s.size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		K = Integer.parseInt(st.nextToken()); // 이동 횟수
		map = new int[N][N];
		cnt = M;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0)
					sList.add(new Shark(i, j, 0, map[i][j], new int[4][4]));
			}
		}

		Collections.sort(sList);
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < sList.size(); i++) {
			int d = Integer.parseInt(st.nextToken());
			sList.get(i).d = d - 1;
		}

		// 우선순위 입력
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int k = 0; k < 4; k++) {
					sList.get(i).prior[j][k] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}

		lezgo();

		if (time > 1000)
			System.out.println(-1);
		else
			System.out.println(time);
	}

	static int cnt = 0, time = 0;

	static void lezgo() {
		if (cnt == 1 || time > 1000) {
			return;
		}

		time++;
		for (int i = 0; i < sList.size(); i++) { // 냄새 뿌리기
			int idx = N * sList.get(i).x + sList.get(i).y;
			smell.put(idx, new int[] {K, sList.get(i).size});
		}

		List<Integer> removeShark = new ArrayList<>();
		for (int i = 0; i < sList.size(); i++) { // 이동하기
			Shark shark = sList.get(i);
			boolean flag = false;
			boolean outFlag = false;
			int tx = 0, ty = 0, dir = 0;
			map[shark.x][shark.y] = 0; // 원래 있던 자리 0 처리

			for (int j = 0; j < 4; j++) {
				dir = shark.prior[shark.d][j];
				tx = shark.x + dx[dir];
				ty = shark.y + dy[dir];

				if (tx < 0 || tx >= N || ty < 0 || ty >= N || smell.containsKey(tx * N + ty))
					continue;

				if (map[tx][ty] != 0) { // 상어가 만난다면
					removeShark.add(i);
					outFlag = true;
					cnt--;
					break;
				}

				flag = true;
				break;
			}

			if (!outFlag) {
				// 이동
				if (flag) {
					map[tx][ty] = shark.size;
					sList.get(i).x = tx;
					sList.get(i).y = ty;
					sList.get(i).d = dir;
				} else { // 이동할 칸이 없으면 왔던 방향으로 한칸 간다. 단, 자신의 냄새가 나야만 한다.
					for (int j = 0; j < 4; j++) {
						dir = shark.prior[shark.d][j];
						tx = shark.x + dx[dir];
						ty = shark.y + dy[dir];
						
						if (tx < 0 || tx >= N || ty < 0 || ty >= N)
							continue;
						
						int idx = tx * N + ty;
						if(smell.containsKey(idx)) { // 칸에 냄새가 뿌려져 있다면
							if(smell.get(idx)[1] == shark.size) { // 그 냄새가 자기꺼라면!!!
								map[tx][ty] = shark.size;
								sList.get(i).x = tx;
								sList.get(i).y = ty;
								sList.get(i).d = dir;
								break;
							}
						}
					}
				}
			}
		}
		
		for(int i = removeShark.size() - 1; i >= 0 ; i--) {
			int idx = removeShark.get(i);
			Shark s = sList.get(idx);
			sList.remove(s);
		}

		// 왔던길 냄새 지우기
		List<Integer> removeList = new ArrayList<>();
		for (int key : smell.keySet()) {
			int[] val = smell.get(key);
			if(val[0] - 1 == 0)
				removeList.add(key);
			else
				smell.put(key, new int[] {val[0] - 1, val[1]});
		}
		
		for(int i = removeList.size() - 1; i >= 0 ; i--)
			smell.remove(removeList.get(i));

		lezgo();
	}

}

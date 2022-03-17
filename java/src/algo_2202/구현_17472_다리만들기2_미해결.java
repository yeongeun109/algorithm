package algo_2202;

import java.io.*;
import java.util.*;

public class 구현_17472_다리만들기2_미해결 {
	// 각 섬의 거리를 구하긴 했는데 최소값이 아님 == 경계~경계의 값이 아님
	// 그게 해결되면 union-find 통해서 최소스패닝트리 만들면 될듯

	static int N, M, areaIdx = 0;
	static int[][] map;
	static List<Integer>[] areaXList = new List[7];
	static List<Integer>[] areaYList = new List[7];

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

//		comb(0, 0);
		
		int[][] dist = new int[areaIdx + 1][areaIdx + 1];
		PriorityQueue<int[]> dist2 = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int i = 1; i <= areaIdx; i++) {
			for (int j = i + 1; j <= areaIdx; j++) {
				dist[i][j] = Integer.MAX_VALUE;
				int a = i;
				int b = j;

				// 겹치는 x가 있는지 체크
				for (int k = 0; k < areaXList[a].size(); k++) {
					int ax = areaXList[a].get(k);
					for (int l = 0; l < areaXList[b].size(); l++) {
						if (areaXList[b].get(l) == ax) {
							// 거리 계산
							int bx = areaXList[b].get(l);
							
							int diff = Math.abs(areaYList[a].get(k) - areaYList[b].get(l)) - 1;
//						System.out.println("a : " + a + ", b : " + b + ", ax : " + ax + ", bx : " + bx);
//							System.out.println(diff);
							dist[a][b] = Math.min(dist[a][b], diff);
						}
					}
					if(dist[a][b] >= 2)
						dist2.add(new int[] {a, b, dist[a][b]});
				}

				// 겹치는 y가 있는지 체크
				for (int k = 0; k < areaYList[a].size(); k++) {
					int ax = areaYList[a].get(k);
					for (int l = 0; l < areaYList[b].size(); l++) {
						if (areaYList[b].get(l) == ax) {
							// 거리 계산
							int bx = areaYList[b].get(l);
							
							int diff = Math.abs(areaXList[a].get(k) - areaXList[b].get(l)) - 1;
							dist[a][b] = Math.min(dist[a][b], diff);
						}
					}
					if(dist[a][b] >= 2)
						dist2.add(new int[] {a, b, dist[a][b]});
				}
			}
		}
		
		for(int i = 0; i <= areaIdx; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
		
		for(int i = 0; i < dist2.size(); i++) {
			System.out.println(Arrays.toString(dist2.poll()));
		}

//		System.out.println(Arrays.toString(areaXList));
//		System.out.println(Arrays.toString(areaYList));
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

//						if(!areaXList[areaIdx].contains(cx))
						areaXList[areaIdx].add(cx);
//						if(!areaYList[areaIdx].contains(cy))
						areaYList[areaIdx].add(cy);

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

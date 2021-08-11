package algo_0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_6497_전력난 {

	static int parents[], N;
	static ArrayList<Edge> edgeList = new ArrayList<Edge>();

	static class Edge implements Comparable<Edge> {
		int x, y;
		int cost;

		public Edge(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			edgeList.clear();
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0)
				break;
			
			parents = new int[N + 1];
			int total = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				total += cost;
				edgeList.add(new Edge(from, to, cost));
			}
			

			Collections.sort(edgeList);

			make();

			int result = 0;
			int count = 0; // 선택한 간선수

			for (Edge edge : edgeList) {
				if (union(edge.x, edge.y)) { // 싸이클이 발생하지 않았다면
					result += edge.cost;
					if (count++ == N - 1)
						break;
				}
			}
			System.out.println(total - result);
		}
	}

	static void make() { // 크기가 1인 단위집합 만들기
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		// 이미 같은 집합인지 조사
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}
}

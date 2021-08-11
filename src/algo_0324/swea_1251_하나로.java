package algo_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea_1251_하나로 {
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.weight < o.weight)
				return -1;
			else if(this.weight > o.weight)
				return 1;
			return 0;
		}
	}

	static void make() { // 크기가 1인 단위집합 만들기
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int N;
	static int parents[];
	static ArrayList<Edge> edgeList = new ArrayList<Edge>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			int[][] island = new int[N][2];
			parents = new int[N];
			edgeList.clear();
			
			for(int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for(int i = 0; i < N; i++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					int from = i;
					int to = j;
					double weight = Math.pow(island[i][0] - island[j][0], 2) + Math.pow(island[i][1] - island[j][1], 2);
					edgeList.add(new Edge(from, to, weight));
				}
			}
			
			Collections.sort(edgeList);
			
			make();
			double L = 0;
			int count = 0;
			
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) { // 싸이클이 발생하지 않았다면
					L += edge.weight;
					if(count++ == N - 1) break;
				}
			}

			double E = Double.parseDouble(in.readLine());
			System.out.println("#" + t + " " + Math.round(L * E));
		}
	}

}

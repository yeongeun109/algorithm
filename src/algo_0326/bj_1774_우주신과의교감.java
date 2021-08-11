package algo_0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class bj_1774_우주신과의교감 {
	
	static int N;
	static ArrayList<Edge> edgeList = new ArrayList<Edge>();
	static int parents[];
	
	static class Edge implements Comparable<Edge>{
		int x, y;
		double weight;

		public Edge(int x, int y, double weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] vertex = new int[N][2];
		parents = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			vertex[i][0] = Integer.parseInt(st.nextToken());
			vertex[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				double temp = Math.pow(Math.abs(vertex[i][0] - vertex[j][0]), 2) + Math.pow(Math.abs(vertex[i][1] - vertex[j][1]), 2);
				edgeList.add(new Edge(i, j, Math.sqrt(temp)));
			}
		}
		
		Collections.sort(edgeList);
		make();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			union(a, b);
		}
		
		double result = 0;
		int count = M;
		
		for(Edge edge : edgeList) {
			if(union(edge.x, edge.y)) {
				result += edge.weight;
				if(count++ == N - 1) break;
			}
		}
		
		System.out.println(String.format("%.2f", result));
	}
	
	static void make() {
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

}

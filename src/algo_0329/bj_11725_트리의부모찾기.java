package algo_0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_11725_트리의부모찾기 {

	static boolean[] visited;
	static int[] parents;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		visited = new boolean[N + 1];
		parents = new int[N + 1];
		list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		dfs(1);
		StringBuilder sb = new StringBuilder();			
		for(int i = 2; i <= N; i++)
			sb.append(parents[i]).append("\n");
		System.out.println(sb);
	}
	private static void dfs(int i) {
		visited[i] = true;
		
		for(int j = 0; j < list[i].size(); j++) {
			if(!visited[list[i].get(j)]) {
				parents[list[i].get(j)] = i;
				dfs(list[i].get(j));
			}
		}
	}

}

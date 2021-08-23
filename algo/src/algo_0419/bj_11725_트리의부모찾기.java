package algo_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_11725_트리의부모찾기 {
	
	static List<Integer>[] list;
	static boolean visited[];
	static int[] res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		res = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();			
		}
		
		for(int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		
		dfs(1);
		StringBuilder sb = new StringBuilder();			
		for(int i = 2; i <= N; i++)
			sb.append(res[i]).append("\n");
		System.out.println(sb);
	}

	private static void dfs(int n) {
		
		visited[n] = true;
		
		for(int i = 0; i < list[n].size(); i++) {
			if(!visited[list[n].get(i)]) {
				res[list[n].get(i)] = n;
				dfs(list[n].get(i));
			}
		}
	}

}

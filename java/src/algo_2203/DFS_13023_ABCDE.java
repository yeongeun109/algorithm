package algo_2203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS_13023_ABCDE {

	static List<Integer>[] list;
	static int N, res = 0;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(0, i);
			if(flag)
				break;
		}
		System.out.println(flag == true ? 1 : 0);
	}

	static boolean flag = false;
	public static void dfs(int cnt, int idx) {
		if(!visited[idx]) {
			visited[idx] = true;
			cnt++;
		}
		
		if (cnt == 5) {
			flag = true;
			return;
		}

		for (int i = 0; i < list[idx].size(); i++) {
			int currIdx = list[idx].get(i);
			
			if (!visited[currIdx]) {
				dfs(cnt, currIdx);
			}
		}
		visited[idx] = false;
	}
}
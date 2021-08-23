package algo_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_1967_트리의지름 {

	static boolean visited[];
	static List<int[]>[] list;
	static int n, max = 0, farNode;

	static public class Node {
		int num;
		int prev;
		int cost;

		public Node(int num, int prev, int cost) {
			super();
			this.num = num;
			this.prev = prev;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		if (n == 1) {
			System.out.println(0);
		} else {
			visited = new boolean[n + 1];
			list = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<int[]>();
			}

			for (int i = 0; i < n - 1; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				list[parent].add(new int[] { child, cost });
				list[child].add(new int[] { parent, cost });

			}

			dfs(1, 0);
			visited = new boolean[n + 1];
			dfs(farNode, 0);
			System.out.println(max);
		}
	}

	private static void dfs(int node, int cost) {
		if (visited[node])
			return;

		visited[node] = true;
		if (max < cost) {
			max = cost;
			farNode = node;
		}

		for (int i = 0; i < list[node].size(); i++) {
			dfs(list[node].get(i)[0], cost + list[node].get(i)[1]);
		}
	}

}

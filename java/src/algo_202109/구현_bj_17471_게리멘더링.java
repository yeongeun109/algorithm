package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구현_bj_17471_게리멘더링 {

	static int[] popul, parent;
	static ArrayList<Integer>[] list;
	static int N, res = Integer.MAX_VALUE;
	static char[] area;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		popul = new int[N];
		list = new ArrayList[N];
		area = new char[N];
		parent = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<Integer>();
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				list[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		comb(0, 0);
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

	private static void comb(int cnt, int start) {
		if (cnt == N) {
			int anum = 0;
			for (int i = 0; i < N; i++) {
				if (area[i] == 'A')
					anum++;
			}
			if (!(anum == 0 || anum == N)) {
				ArrayList<Integer> a = new ArrayList<>();
				ArrayList<Integer> b = new ArrayList<>();
				for (int i = 0; i < N; i++) {
					if (area[i] == 'A')
						a.add(i);
					else
						b.add(i);
				}

				boolean aflag = true, bflag = true;

				for (int i = 0; i < a.size(); i++) {
					int from = a.get(i);
					boolean flag = true;
					for (int j = i + 1; j < a.size(); j++) {
						int to = a.get(j);

						if (list[from].contains(to))
							continue;

						boolean[] visited = new boolean[N];
						if (!dfs(from, to, 'A', visited)) {
							flag = false;
							break;
						}
					}

					if (!flag) {
						aflag = false;
						break;
					}
				}
				for (int i = 0; i < b.size(); i++) {
					int from = b.get(i);
					boolean flag = true;
					for (int j = i + 1; j < b.size(); j++) {
						int to = b.get(j);

						if (list[from].contains(to))
							continue;

						boolean[] visited = new boolean[N];
						if (!dfs(from, to, 'B', visited)) {
							flag = false;
							break;
						}
					}
					if (!flag) {
						bflag = false;
						break;
					}
				}

				if (aflag && bflag) {
					int ap = 0, bp = 0;
					for (int i = 0; i < a.size(); i++) {
						ap += popul[a.get(i)];
					}
					for (int i = 0; i < b.size(); i++) {
						bp += popul[b.get(i)];
					}

					res = Math.min(res, Math.abs(ap - bp));
				}

			}
			return;
		}

		for (int i = start; i < N; i++) {
			area[cnt] = 'A';
			comb(cnt + 1, i + 1);
			area[cnt] = 'B';
			comb(cnt + 1, i + 1);
		}
	}

	private static boolean dfs(int from, int to, char tarea, boolean[] visited2) {
		if (list[from].contains(to))
			return true;

		for (int i = 0; i < list[from].size(); i++) {
			int that = list[from].get(i);

			if (area[that] == tarea && !visited2[that]) {
				visited2[that] = true;
				if (dfs(that, to, tarea, visited2))
					return true;
			}
		}

		return false;
	}

}

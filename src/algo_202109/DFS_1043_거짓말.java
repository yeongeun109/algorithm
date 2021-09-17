package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_1043_거짓말 {

	static int N, M;
	static boolean[] truth;
	static int[] people;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		truth = new boolean[N];
		
		st = new StringTokenizer(in.readLine(), " ");
		int truthnum = Integer.parseInt(st.nextToken());
		for(int i = 0; i < truthnum; i++) {
			int num = Integer.parseInt(st.nextToken()) - 1;
			truth[num] = true;
		}
		
		list = new ArrayList[M];
		for(int i = 0; i < M; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(in.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++)
				list[i].add(Integer.parseInt(st.nextToken()) - 1);
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < list[i].size(); j++) {
				if(truth[list[i].get(j)]) {
					boolean[] visited = new boolean[N];
					dfs(list[i].get(j), visited);
				}
			}
		}
		
		int res = 0;
		
		for(int i = 0; i < M; i++) {
			boolean flag = true;
			for(int j = 0; j < list[i].size(); j++) {
				if(truth[list[i].get(j)]) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				res++;
		}
		System.out.println(res);
	}

	private static void dfs(int p, boolean[] v) {
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < list[i].size(); j++) {
				if(list[i].contains(p)){
					for(int k = 0; k < list[i].size(); k++) {
						if(!v[list[i].get(k)] && !truth[list[i].get(k)]) {
							truth[list[i].get(k)] = true;
							v[list[i].get(k)] = true;
							dfs(list[i].get(k), v);
						}
					}
				}
			}
		}
	}

}

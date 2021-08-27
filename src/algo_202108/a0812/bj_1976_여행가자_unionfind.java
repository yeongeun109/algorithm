package algo_202108.a0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1976_여행가자_unionfind {
	
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		parents = new int[N];
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(i != j && num == 1) {
					union(i, j);
				}
			}
		}
		
		System.out.println(Arrays.toString(parents));
		st = new StringTokenizer(in.readLine(), " ");
		int from = Integer.parseInt(st.nextToken()) - 1;
		String res = "YES";
		
		for(int i = 1; i < M; i++) {
			int to = Integer.parseInt(st.nextToken()) - 1;
			if(parents[from] != parents[to]) {
				res = "NO";
				break;
			}
			from = to;
		}
		System.out.println(res);
	}

	private static void union(int i, int j) {
		int rootA = find(i);
		int rootB = find(j);
		
		if(rootA != rootB) {
			parents[rootB] = rootA;
		}
	}

	private static int find(int i) {
		if(parents[i] == i)
			return i;
		
		return parents[i] = find(parents[i]);
	}
	

}

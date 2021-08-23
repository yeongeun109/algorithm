package algo_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_14496_그대그머가되어 {

	static List<Integer>[] list;
	static boolean[] visited;
	static int a, b, res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N + 1];
		int[] d = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
			d[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		pq.offer(new int[] {a, 0});
		d[a] = 0;
		
		while(!pq.isEmpty()) {
			int temp[] = pq.poll();
			int v = temp[0];
			int c = temp[1];
			
			for(int i = 0; i < list[v].size(); i++) {
				if(d[list[v].get(i)] > c + 1) {
					d[list[v].get(i)] = c + 1;
					pq.offer(new int[] {list[v].get(i), c + 1});
				}
			}
		}
		
		if(d[b] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(d[b]);
	}

}

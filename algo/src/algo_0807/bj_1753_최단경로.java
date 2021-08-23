package algo_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

public class bj_1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());	
		int start = Integer.parseInt(in.readLine());
		
		ArrayList<int[]>[] list = new ArrayList[V+1];
		int[] d = new int[V+1];
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<int[]>();
			d[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to, cost});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		pq.offer(new int[] {start, 0});
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int currV = tmp[0];
			int currC = tmp[1];
			
			for(int i = 0; i < list[currV].size(); i++) {
				int tmpV = list[currV].get(i)[0];
				int tmpC = list[currV].get(i)[1];
				if(d[tmpV] > currC + tmpC) {
					d[tmpV] = currC + tmpC;
					pq.offer(new int[] {tmpV, d[tmpV]});
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(d[i] != Integer.MAX_VALUE)
				System.out.println(d[i]);
			else
				System.out.println("INF");
		}
	}

}
